package com.roofflex.springboot.cruddemo.controller;


import com.roofflex.springboot.cruddemo.entity.Employee;
import com.roofflex.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    // Get single employee

    @GetMapping("/employees/{employeeId}")
    public Employee getSingleEmployee(@PathVariable int employeeId){
        return employeeService.getSingleEmployee(employeeId);
    }

    // Create employee

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return "Successfully created an employee";
    }

    // Update employee

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return "Successfully updated an employee";
    }

    // Delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
        return "Successfully deleted an employee";
    }


}
