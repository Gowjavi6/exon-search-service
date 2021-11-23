package com.accenture.exon.searchservice.repository.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Data
@Table(name = "EMPLOYEE",schema = "EXON")
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Employee_Id")
    private String employeeId;

    @Column(name="Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address_Line_1")
    private String addressLine1;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Create_Date")
    private String createDate;
}

