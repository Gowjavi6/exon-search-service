package com.accenture.exon.searchservice.repository;

import com.accenture.exon.searchservice.repository.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExonRepository {

    List<Employee> findEmployeeByEmail(String email);
    List<Employee> findEmployeeByName(String name);
    List<Employee> findEmployeeByCity(String city);
}
