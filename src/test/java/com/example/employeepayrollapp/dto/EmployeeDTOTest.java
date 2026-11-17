
package com.example.employeepayrollapp.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDTOTest {

    @Test
    void givenEmployeeDetails_whenDTOCreated_shouldReturnDetails() {
        EmployeeDTO employee = new EmployeeDTO("Lisa", 2000);

        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    @Test
    void givenEmployeeDTO_whenSalaryUpdated_shouldReturnUpdatedSalary() {
        EmployeeDTO employee = new EmployeeDTO("Lisa", 2000);

        employee.setSalary(3000);

        assertEquals(3000, employee.getSalary());
    }
}
