package com.example.registrationlogin.service;

import com.example.registrationlogin.data.Employee;
import com.example.registrationlogin.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String authenticateUser(String username, String password) {
        Employee employee = employeeRepository.findByUsernameAndPassword(username, password);

        if (employee != null) {
            return "Login Successful!";
        } else {
            return "Invalid username or password.";
        }
    }
}
