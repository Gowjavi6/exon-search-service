package com.accenture.exon.searchservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchRequest {
    String value;
}
