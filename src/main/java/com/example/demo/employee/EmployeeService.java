package com.example.demo.employee;

import com.example.demo.dto.EmployeeDto;
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

    @Transactional(rollbackFor = Exception.class)
    public void updateEmployee(EmployeeDto request){
        var employeeDto = request;
    }

}
