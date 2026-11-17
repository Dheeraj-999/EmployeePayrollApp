
package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.service.EmployeePayrollService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollControllerTest {

    private final EmployeePayrollService service =
            new EmployeePayrollService();

    private final EmployeePayrollController controller =
            new EmployeePayrollController(service);

    @Test
    void givenWelcomeRequest_whenCalled_shouldReturnWelcomeMessage() {
        assertEquals(
                "Welcome to Employee Payroll App!",
                controller.getWelcomeMessage()
        );
    }

    @Test
    void givenEmployeeDetails_whenCreated_shouldReturnEmployee() {
        var employee = controller.createEmployee(
                new EmployeeDTO("Lisa", 2000)
        );

        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    @Test
    void givenEmployeeId_whenFetched_shouldReturnEmployee() {
        controller.createEmployee(new EmployeeDTO("John", 3000));

        var employee = controller.getEmployeeById(1);

        assertNotNull(employee);
        assertEquals("John", employee.getName());
    }
}
