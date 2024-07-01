package com.example.registrationlogin.controller;

import com.example.registrationlogin.data.Employee;
import com.example.registrationlogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public String authenticateUser(@RequestBody Employee employee) {
        return employeeService.authenticateUser(employee.getUsername(), employee.getPassword());
    }
}
