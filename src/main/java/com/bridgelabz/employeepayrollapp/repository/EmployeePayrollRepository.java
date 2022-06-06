package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/***********************************************************************************************************************
 * Interface :- Employee Payroll Repository Interface .
 * @author Mangesh
 * @date 05-06-2022
 **********************************************************************************************************************/

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

    @Query(value = "select * from employee_payroll, employee_department where employee_id = id and department = :department", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);

}
