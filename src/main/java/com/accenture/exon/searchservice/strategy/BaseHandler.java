package com.accenture.exon.searchservice.strategy;

import com.accenture.exon.searchservice.dto.EmployeeSearchDto;
import com.accenture.exon.searchservice.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BaseHandler {

    default EmployeeSearchDto mapResults(Employee employee) {
        return EmployeeSearchDto.builder().employeeId(UUID.fromString(employee.getEmployeeId()))
                                    .addressLine1(employee.getAddressLine1())
                                    .city(employee.getCity())
                                    .createDate(employee.getCreateDate())
                                    .email(employee.getEmail())
                                    .name(employee.getName()).build();
    }

}
