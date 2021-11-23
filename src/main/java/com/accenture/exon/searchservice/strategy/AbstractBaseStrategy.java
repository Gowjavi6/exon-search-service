package com.accenture.exon.searchservice.strategy;

import com.accenture.exon.searchservice.annotation.ExonHandlerStrategy;
import com.accenture.exon.searchservice.exception.SearchException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractBaseStrategy<T> implements Strategy<T> {

    String action;
    int order;

    public AbstractBaseStrategy() {
        try {
            ExonHandlerStrategy declaration = this.getClass().getAnnotation(ExonHandlerStrategy.class);
            if (Optional.ofNullable(declaration).isPresent()) {
                this.action = declaration.action();
                this.order = declaration.order();
            }
        }catch(Exception ex){
            log.error("Exception :",ex.getMessage());
        }
    }

    protected abstract List<T> getHandler(String value) throws SearchException;

    @Override
    public String getAction() {
        return this.action;
    }

    @Override
    public List<T> handler(String value) throws SearchException {
        return getHandler(value);
    }


}
