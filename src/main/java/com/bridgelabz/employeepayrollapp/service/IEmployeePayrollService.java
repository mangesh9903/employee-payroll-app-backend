package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.time.LocalDate;
import java.util.List;

/***********************************************************************************************************************
 * Interface :- Interface for Employee Payroll Service.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);

     List<EmployeePayrollData> getEmployeePayrollDataByDepartment(String department);

    List<EmployeePayrollData> getEmployeePayrollDataBySalary(long salary);

    List<EmployeePayrollData> getEmployeePayrollDataByGender(String gender);

    List<EmployeePayrollData> getEmployeePayrollDataByStartDate(LocalDate startDate);
}
