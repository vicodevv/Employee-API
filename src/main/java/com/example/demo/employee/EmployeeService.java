package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
        Optional<Employee> employeeOptional =
                employeeRepository.findEmployeebyEmail(employee.getEmail());

        if(employeeOptional.isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        employeeRepository.save(employee);
    }
    public void deleteEmployee(Long employeeId){
        boolean exists = employeeRepository.existsById(employeeId);

        if(!exists){
            throw new IllegalStateException(
                    "Employee with id " + employeeId + " does not exist"
            );
        }
        employeeRepository.deleteById(employeeId);
    }
    @Transactional
    public void updateEmployee(Long employeeId,
                                String firstName,
                               String lastName,
                               String email){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("Employee with " + employeeId + " does not exist"));

        if(firstName != null &&
            firstName.length() > 0 &&
            !Objects.equals(employee.getFirstName(), firstName)){
            employee.setFirstName(firstName);
        }

        if(lastName != null &&
            lastName.length() > 0 &&
            !Objects.equals(employee.getLastName(), lastName)){
            employee.setLastName(lastName);
        }
        if(email != null &&
            email.length() > 0 &&
            !Objects.equals(employee.getEmail(), email)){
            Optional<Employee> employeeOptional = employeeRepository
                    .findEmployeebyEmail(email);
            if(employeeOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            employee.setEmail(email);
        }
    }

}
