package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();

    }
    @PostMapping()
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }
    @DeleteMapping(path = "{EmployeeId}")
    public void deleteEmployee(
            @PathVariable("EmployeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
    @PutMapping(path = {"EmployeeId"})
    public void updateEmployee(
            @PathVariable("EmployeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        employeeService.updateEmployee(employeeId, name, email);

    }
}
