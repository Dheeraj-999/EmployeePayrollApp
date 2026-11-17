
package com.example.employeepayrollapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollDataTest {

    @Test
    void givenEmployeeDetails_whenCreated_shouldReturnEmployeeDetails() {

        EmployeePayrollData employee =
                new EmployeePayrollData(1, "Lisa", 2000);

        assertEquals(1, employee.getId());
        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    @Test
    void givenEmployee_whenSalaryUpdated_shouldReturnUpdatedSalary() {

        EmployeePayrollData employee =
                new EmployeePayrollData(1, "Lisa", 2000);

        employee.setSalary(3000);

        assertEquals(3000, employee.getSalary());
    }
}
