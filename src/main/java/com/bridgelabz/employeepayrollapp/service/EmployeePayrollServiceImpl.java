package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************************
 * Class :- Employee Payroll Service Implementation Class .
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@Service
@Slf4j
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    private final List<EmployeePayrollData> empDataList = new ArrayList<>();

    @Autowired
    private EmployeePayrollRepository payrollRepository;

    /**
     * Method :- Method to Get All Employee Payroll Data.
     *
     * @return Returning Employee Payroll List.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return payrollRepository.findAll();
    }

    /**
     * Method :- Method to Get  Employee Payroll Data By Id.
     *
     * @param empId :- Passing empId As Input.
     * @return Returning Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return payrollRepository.findById(empId).orElseThrow(() ->
                new EmployeePayrollException("Employee with Employee Id " + empId + " Does Not Exists In Database."));

    }

    /**
     * Method :- Method to Create Employee Payroll Data.
     *
     * @param employeePayrollDTO :- Passing employeePayrollDTO As Input.
     * @return Returning Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollDTO);
        log.debug("Emp Data: " + empData);
        payrollRepository.save(empData);
        return empData;
    }

    /**
     * Method :- Method to Update Employee Payroll Data.
     *
     * @param empId              :- Passing empId As Input.
     * @param employeePayrollDTO :- Passing employeePayrollDTO As Input.
     * @return Returning updated Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        payrollRepository.save(empData);
        return empData;
    }

    /**
     * Method :- Method to Delete Employee Payroll Data.
     *
     * @param empId :- Passing empId As Input.
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        payrollRepository.delete(empData);
    }

    /** Method :- Method to Get Employee Payroll Data By Department.
     *
     * @param department :- Passing department As Input.
     * @return :- Returning Employee Payroll Data who's Department Are Same.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollDataByDepartment(String department) {
        return payrollRepository.findEmployeesByDepartment(department);
    }

    /** Method :- Method to Get Employee Payroll Data By Salary.
     *
     * @param salary :- Passing salary As Input.
     * @return :- Returning Employee Payroll Data who's Salary is Same.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollDataBySalary(long salary) {
        return payrollRepository.findEmployeesBySalary(salary);
    }

    /** Method :- Method to Get Employee Payroll Data By Gender.
     *
     * @param gender :- Passing gender As Input.
     * @return :- Returning Employee Payroll Data who's gender is Same.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollDataByGender(String gender) {
        return  payrollRepository.findEmployeesByGender(gender);
    }

    /** Method :- Method to Get Employee Payroll Data By StartDate.
     *
     * @param startDate :- Passing startDate As Input.
     * @return :- Returning Employee Payroll Data who's startDate is Same.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollDataByStartDate(LocalDate startDate) {
        return payrollRepository.findEmployeesByStartDate(startDate);
    }
}
