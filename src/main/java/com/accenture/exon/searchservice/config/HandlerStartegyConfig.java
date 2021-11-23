package com.accenture.exon.searchservice.config;

import com.accenture.exon.searchservice.annotation.ExonHandlerStrategy;
import com.accenture.exon.searchservice.constants.ScopeType;
import com.accenture.exon.searchservice.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class HandlerStartegyConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    public Map<String, Strategy> handlers() {
        return loadHandlers(ScopeType.Handlers, "com.accenture.exon.searchservice");
    }

    protected Map<String, Strategy> loadHandlers(ScopeType scope, String scanPath) {
        Map<String, Strategy> strategies = new HashMap<>();
        try {
            ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
            provider.addIncludeFilter(new AnnotationTypeFilter(ExonHandlerStrategy.class));
            provider.findCandidateComponents(scanPath).forEach(beanDefinition -> {
                try {
                    Class<?> cl = Class.forName(beanDefinition.getBeanClassName());
                    ExonHandlerStrategy annotation = cl.getAnnotation(ExonHandlerStrategy.class);
                    if (annotation.scope() == scope) {
                        Strategy strategy = (Strategy) context.getBean(cl);
                        strategies.put(annotation.action(), strategy);
                    }
                    log.info("strategies ::: " + strategies.toString());
                } catch (ClassNotFoundException e) {
                    log.debug(" Error getting search strategy bean.", e);
                }
            });
        } catch (Exception e) {
            log.debug(" Error getting search strategy bean.", e);
        }


        return strategies;
    }



}
