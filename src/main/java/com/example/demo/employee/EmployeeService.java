package com.example.demo.employee;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getEmployees(){
        return List.of(
                new Employee(
                        1L,
                        "Victor",
                        "Omoniyi",
                        "Software Engineer I",
                        "Male",
                        LocalDate.of(2001, 7, 13),
                        "vomoniyi2001@gmail.com"

                )
        );
    }
}
