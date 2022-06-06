package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/***********************************************************************************************************************
 * Interface :- Employee Payroll Repository Interface .
 * @author Mangesh
 * @date 05-06-2022
 **********************************************************************************************************************/

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
