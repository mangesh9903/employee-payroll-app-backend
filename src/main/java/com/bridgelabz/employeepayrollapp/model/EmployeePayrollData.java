package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/***********************************************************************************************************************
 * Class :- Employee Payroll Data.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/

@ToString
@Table(name = "EmployeePayroll")
@Entity
public @Data
class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    private String name;

    private long salary;

    private String gender;

    private LocalDate startDate;

    private String note;

    private String profilePic;

    private List<String> department;


    public EmployeePayrollData() {

    }


    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.note = employeePayrollDTO.note;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.department = employeePayrollDTO.department;
    }
}
