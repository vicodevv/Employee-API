package com.example.demo.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee Victor = new Employee(
                    "Victor",
                    "Omoniyi",
                    "Software Engineer I",
                    "Male",
                    LocalDate.of(2001, 7, 13),
                    "victoroomoniyi@gmail.com"
            );
            Employee Orero = new Employee(
                    "Orero",
                    "Ozore",
                    "Software Engineer I",
                    "Male",
                    LocalDate.of(2001, 7, 13),
                    "ozoreorero@gmail.com"
            );
            repository.saveAll(
                    List.of(Victor, Orero)
            );
        };
    }
}
