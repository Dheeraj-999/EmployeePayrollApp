
package com.example.employeepayrollapp.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeePayrollControllerTest {

    EmployeePayrollController controller =
            new EmployeePayrollController();

    @Test
    void givenWelcomeRequest_whenCalled_shouldReturnWelcomeMessage() {

        String response = controller.getWelcomeMessage();

        assertEquals(
                "Welcome to Employee Payroll App!",
                response
        );
    }

    @Test
    void givenEmployeeId_whenGetEmployeeById_shouldReturnMessage() {

        String response = controller.getEmployeeById(1);

        assertEquals(
                "Fetching Employee with ID: 1",
                response
        );
    }
}
