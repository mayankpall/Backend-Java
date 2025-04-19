package com.bridglabz.employeepayrollapp.repository;

import com.bridglabz.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
