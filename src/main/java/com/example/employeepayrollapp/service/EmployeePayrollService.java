
package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService {

    private final EmployeePayrollRepository repository;

    // Constructor Dependency Injection
    public EmployeePayrollService(EmployeePayrollRepository repository) {
        this.repository = repository;
    }

    // Get all employees
    public List<EmployeePayrollData> getAllEmployees() {
        return repository.findAll();
    }

    // Get employee by ID
    public EmployeePayrollData getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Add employee
    public EmployeePayrollData addEmployee(EmployeeDTO employeeDTO) {

        EmployeePayrollData employee = new EmployeePayrollData(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        return repository.save(employee);
    }

    // Update employee
    public EmployeePayrollData updateEmployee(
            int id, EmployeeDTO employeeDTO) {

        EmployeePayrollData employee = getEmployeeById(id);

        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());

            return repository.save(employee);
        }

        return null;
    }

    // Delete employee
    public boolean deleteEmployee(int id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
