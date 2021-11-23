package com.accenture.exon.searchservice.service;

import com.accenture.exon.searchservice.dto.EmployeeSearchDto;
import com.accenture.exon.searchservice.exception.SearchException;
import com.accenture.exon.searchservice.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    @Qualifier("employeeSearchStrategies")
    Map<String, Strategy> employeeStrategies;

    @Override
    public List<EmployeeSearchDto> search(String searchRequest) throws SearchException {
        Strategy strategy = employeeStrategies.get(System.getenv("search.type"));
        return strategy.handler(searchRequest);
    }
}
