package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollServiceImpl;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/***********************************************************************************************************************
 * Class :- Employee Payroll Controller.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@RequestMapping("/employeepayroll")
@RestController
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * Method :- Method to Get the Employee Payroll Data.
     *
     * @return :- Returning ResponseDTO Object.
     */
    @GetMapping("/getEmpInfo")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful.",
                empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Get the Employee Payroll Data Using Employee ID.
     *
     * @param empId :- passing Employee Id As Input
     * @return :- Returning ResponseDTO Object.
     */
    @GetMapping("/getEmpInfoById/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable int empId) {

        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",
                empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     *
     * @param department :- passing department As Input
     * @return :- Returning Employee Info By Department.
     */
    @GetMapping("/getEmpInfoByDepartment/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByDepartment(@PathVariable String department) {

        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollDataByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",
                empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Create the Employee Payroll Data.
     *
     * @param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * @return :-  Returning ResponseDTO Object.
     */
    @PostMapping("/createEmployee")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {

        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);

    }

    /**
     * Method :- Method to Update the Employee Payroll Data.
     *
     * @param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * @return :-  Returning ResponseDTO Object.
     */
    @PutMapping("/updateEmployee/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@PathVariable("empId") int empId, @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully.", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Delete the Employee Payroll Data.
     *
     * @param empId :- passing Employee Id As Input.
     * @return Returning ResponseDTO Object.
     */
    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully, ", "Deleted Id : " + empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getEmpInfoBySalary/{salary}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataBySalary(@PathVariable long salary) {

        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollDataBySalary(salary);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",
                empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getEmpInfoByGender/{gender}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByGender(@PathVariable String gender) {

        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollDataByGender(gender);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",
                empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getEmpInfoByStartDate/{startDate}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByGender(@PathVariable LocalDate startDate) {

        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollDataByStartDate(startDate);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful",
                empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
