
package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    @Test
    void givenEmployeeDetails_whenAdded_shouldReturnEmployee() {
        EmployeePayrollService service = new EmployeePayrollService();

        EmployeeDTO dto = new EmployeeDTO("Lisa", 2000);
        EmployeePayrollData employee = service.addEmployee(dto);

        assertEquals(1, employee.getId());
        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    @Test
    void givenEmployeeId_whenFetched_shouldReturnEmployee() {
        EmployeePayrollService service = new EmployeePayrollService();

        service.addEmployee(new EmployeeDTO("Lisa", 2000));

        EmployeePayrollData employee = service.getEmployeeById(1);

        assertNotNull(employee);
        assertEquals("Lisa", employee.getName());
    }

    @Test
    void givenEmployeeDetails_whenUpdated_shouldUpdateEmployee() {
        EmployeePayrollService service = new EmployeePayrollService();

        service.addEmployee(new EmployeeDTO("Lisa", 2000));
        EmployeePayrollData updatedEmployee =
                service.updateEmployee(1, new EmployeeDTO("John", 3000));

        assertNotNull(updatedEmployee);
        assertEquals("John", updatedEmployee.getName());
        assertEquals(3000, updatedEmployee.getSalary());
    }

    @Test
    void givenEmployeeId_whenDeleted_shouldRemoveEmployee() {
        EmployeePayrollService service = new EmployeePayrollService();

        service.addEmployee(new EmployeeDTO("Lisa", 2000));

        boolean result = service.deleteEmployee(1);

        assertTrue(result);
        assertNull(service.getEmployeeById(1));
    }
}
