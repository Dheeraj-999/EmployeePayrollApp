
package com.example.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // UC2: Welcome API
    @GetMapping({"", "/"})
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    // UC2: Get Employee by ID
    @GetMapping("/get/{empId}")
    public String getEmployeeById(@PathVariable int empId) {
        return "Fetching Employee with ID: " + empId;
    }
}
