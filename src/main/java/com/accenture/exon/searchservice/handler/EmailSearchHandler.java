package com.accenture.exon.searchservice.handler;

import com.accenture.exon.searchservice.dto.EmployeeSearchDto;
import com.accenture.exon.searchservice.repository.ExonRepository;
import com.accenture.exon.searchservice.strategy.BaseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class EmailSearchHandler implements BaseHandler {

    @Autowired
    ExonRepository exonRepository;

    public List<EmployeeSearchDto> doSearch(String value) {
        return exonRepository.findEmployeeByEmail(value).stream().map(this::mapResults).collect(Collectors.toList());
    }

}
