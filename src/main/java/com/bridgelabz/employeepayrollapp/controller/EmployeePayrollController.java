package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***********************************************************************************************************************
 * Class :- Employee Payroll Controller.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@RequestMapping("/employeepayroll")
@RestController
public class EmployeePayrollController {

    /**
     * Method :- Method to Get the Employee Payroll Data.
     *
     * @return :- Returning ResponseDTO Object.
     */
    @GetMapping("/getEmpInfo")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj", 30000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Get the Employee Payroll Data Using Employee ID.
     *
     * @param empId :- passing Employee Id As Input
     * @return :- Returning ResponseDTO Object.
     */
    @GetMapping("/getEmpInfoById/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable long empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj", 30000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Create the Employee Payroll Data.
     *
     * @param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * @return :-  Returning ResponseDTO Object.
     */
    @PostMapping("/createEmployee")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Update the Employee Payroll Data.
     *
     * @param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * @return :-  Returning ResponseDTO Object.
     */
    @PutMapping("/updateEmployee")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully.",
                employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Delete the Employee Payroll Data.
     *
     * @param empId :- passing Employee Id As Input.
     * @return Returning ResponseDTO Object.
     */
    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable("empId") long empId) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully, ", "Deleted Id : " + empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
