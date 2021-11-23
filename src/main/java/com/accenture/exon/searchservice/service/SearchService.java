package com.accenture.exon.searchservice.service;

import com.accenture.exon.searchservice.dto.EmployeeSearchDto;
import com.accenture.exon.searchservice.exception.SearchException;

import java.util.List;

public interface SearchService {

    public List<EmployeeSearchDto> search(String searchRequest) throws SearchException;
}
