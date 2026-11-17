
package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.service.EmployeePayrollService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private final EmployeePayrollService employeePayrollService;

    // Constructor Dependency Injection
    public EmployeePayrollController(EmployeePayrollService employeePayrollService) {
        this.employeePayrollService = employeePayrollService;
    }

    // Get welcome message
    @GetMapping({"", "/"})
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    // Get all employees
    @GetMapping("/get")
    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployeeById(@PathVariable int id) {
        return employeePayrollService.getEmployeeById(id);
    }

    // Add employee
    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.addEmployee(employeeDTO);
    }

    // Update employee
    @PutMapping("/update/{id}")
    public EmployeePayrollData updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }

    // Delete employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean deleted = employeePayrollService.deleteEmployee(id);

        return deleted
                ? "Employee deleted successfully"
                : "Employee not found";
    }
}
