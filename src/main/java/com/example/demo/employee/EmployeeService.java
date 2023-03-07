package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public void addNewEmployee(Employee employee){
        Optional<Employee> employeeByEmail =
                employeeRepository.findEmployeebyEmail(employee.getEmail());

        if(employeeByEmail.isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        System.out.println(employee);
    }
}
