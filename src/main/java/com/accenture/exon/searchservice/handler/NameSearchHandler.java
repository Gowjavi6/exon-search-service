package com.accenture.exon.searchservice.handler;

import com.accenture.exon.searchservice.dto.EmployeeSearchDto;
import com.accenture.exon.searchservice.repository.ExonRepository;
import com.accenture.exon.searchservice.strategy.BaseHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class NameSearchHandler implements BaseHandler {

    @Autowired
    ExonRepository exonRepository;

    public List<EmployeeSearchDto> doSearch(String value) {
        return exonRepository.findEmployeeByName(value).stream().map(this::mapResults).collect(Collectors.toList());
    }
}
