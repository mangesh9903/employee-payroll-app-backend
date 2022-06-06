package com.bridgelabz.employeepayrollapp.exception;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
/***********************************************************************************************************************
 * Class :- Employee Payroll Exceptional Handler Class .
 * @author Mangesh
 * @date 05-06-2022
 **********************************************************************************************************************/
@ControllerAdvice
public class EmployeePayrollExceptionalHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
