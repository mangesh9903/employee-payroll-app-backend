package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************************
 * Class :- Employee Payroll Service Implementation Class .
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/

public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    /**
     * Method :- Method to Get All Employee Payroll Data.
     *
     * @return Returning Employee Payroll List.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = new ArrayList<>();
        empDataList.add(new EmployeePayrollData(1,
                new EmployeePayrollDTO("Mangesh", 5000)));
        return empDataList;
    }

    /**
     * Method :- Method to Get  Employee Payroll Data By Id.
     *
     * @param empId :- Passing empId As Input.
     * @return Returning Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(long empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,
                new EmployeePayrollDTO("Mangesh", 50000));
        return empData;

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
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        return empData;
    }

    /**
     * Method :- Method to Update Employee Payroll Data.
     *
     * @param employeePayrollDTO :- Passing employeePayrollDTO As Input.
     * @return Returning updated Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(long empId) {

    }
}
