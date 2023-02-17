package com.example.demo;

import com.example.demo.employee.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public List<Employee> hello(){
		return List.of(
				new Employee(
						1L,
						"Victor",
						"Omoniyi",
						"Software Engineer I",
						"Male",
						LocalDate.of(2001, 07, 13),
						"vomoniyi2001@gmail.com"

				)
		);
	}
}
