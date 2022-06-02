package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
import lombok.ToString;

/***********************************************************************************************************************
 * Class :- Employee Payroll DTO.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@Data
@ToString
public class EmployeePayrollDTO {

    public String name;
    public long salary;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
