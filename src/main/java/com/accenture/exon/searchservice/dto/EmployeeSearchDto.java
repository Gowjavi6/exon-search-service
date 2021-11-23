package com.accenture.exon.searchservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchDto {

    UUID employeeId;

    String name;

    String email;

    String addressLine1;

    String city;

    String state;

    String createDate;
}
