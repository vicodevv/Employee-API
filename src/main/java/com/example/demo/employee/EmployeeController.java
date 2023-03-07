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

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(
            @PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = {"employeeId"})
    //@RequestMapping(path = {"employeeId"}, method = RequestMethod.PUT)
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody(required = false) String firstName,
            @RequestBody(required = false) String lastName,
            @RequestBody(required = false) String email){
        employeeService.updateEmployee(employeeId, firstName, lastName, email);

    }
}
