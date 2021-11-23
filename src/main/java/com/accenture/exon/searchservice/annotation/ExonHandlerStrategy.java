package com.accenture.exon.searchservice.annotation;

import com.accenture.exon.searchservice.constants.ScopeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface ExonHandlerStrategy {

    String action();

    int order();

    ScopeType scope();
}
