package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/***********************************************************************************************************************
 * Class :- Employee Payroll Data.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@Data
@ToString
@Table(name = "EmployeePayroll")
@Entity
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    private String name;

    private long salary;

    private String createdDate;

    private String updatedDate;

    public EmployeePayrollData() {

    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {

        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

}
