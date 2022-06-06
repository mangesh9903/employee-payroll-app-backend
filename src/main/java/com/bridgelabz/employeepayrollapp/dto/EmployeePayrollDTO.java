package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/***********************************************************************************************************************
 * Class :- Employee Payroll DTO.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@Data
public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name Invalid!!!")
    @NotEmpty(message = "Employee name cannot be null")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

    public String gender;

    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> department;

}
