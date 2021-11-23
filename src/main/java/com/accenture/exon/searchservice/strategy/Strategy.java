package com.accenture.exon.searchservice.strategy;

import com.accenture.exon.searchservice.exception.SearchException;

import java.util.List;

public interface Strategy<T> {


    String getAction();

    int getOrder();

    List<T> handler(String value) throws SearchException;
}
