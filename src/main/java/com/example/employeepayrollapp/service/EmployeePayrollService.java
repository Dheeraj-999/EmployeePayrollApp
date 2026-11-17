
package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    private int nextId = 1;

    // Get all employees
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public EmployeePayrollData getEmployeeById(int id) {
        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Add employee
    public EmployeePayrollData addEmployee(EmployeeDTO employeeDTO) {
        EmployeePayrollData employee = new EmployeePayrollData(
                nextId++,
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        employeeList.add(employee);
        return employee;
    }

    // Update employee
    public EmployeePayrollData updateEmployee(int id, EmployeeDTO employeeDTO) {
        EmployeePayrollData employee = getEmployeeById(id);

        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
        }

        return employee;
    }

    // Delete employee
    public boolean deleteEmployee(int id) {
        EmployeePayrollData employee = getEmployeeById(id);

        if (employee != null) {
            employeeList.remove(employee);
            return true;
        }

        return false;
    }
}
