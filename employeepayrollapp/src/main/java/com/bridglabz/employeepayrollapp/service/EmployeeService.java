package com.bridglabz.employeepayrollapp.service;


import com.bridglabz.employeepayrollapp.model.Employee;
import com.bridglabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee){
       Optional<Employee> employee = employeeRepository.findById(id);

       return  employeeRepository.findById(id).map(
               emp -> {
           emp.setName(updatedEmployee.getName());
           emp.setSalary(updatedEmployee.getSalary());
                   return employeeRepository.save(emp);
               }
       ).orElseThrow(() -> new RuntimeException("Employee not found"));


    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
