package com.accenture.exon.searchservice.controller;

import com.accenture.exon.searchservice.dto.EmployeeSearchDto;
import com.accenture.exon.searchservice.dto.SearchRequest;
import com.accenture.exon.searchservice.exception.SearchException;
import com.accenture.exon.searchservice.service.SearchService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    SearchService searchService;

    @PostMapping(value = "/employee/search/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeSearchDto> search(@RequestBody SearchRequest request) throws SearchException {
        return searchService.search(request.getValue());
    }

}
