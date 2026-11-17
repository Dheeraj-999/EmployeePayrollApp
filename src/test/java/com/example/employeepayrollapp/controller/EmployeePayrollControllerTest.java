
package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import com.example.employeepayrollapp.service.EmployeePayrollService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeePayrollControllerTest {

    @Mock
    private EmployeePayrollRepository repository;

    private EmployeePayrollService service;
    private EmployeePayrollController controller;

    @BeforeEach
    void setUp() {
        service = new EmployeePayrollService(repository);
        controller = new EmployeePayrollController(service);
    }

    @Test
    void givenWelcomeRequest_whenCalled_shouldReturnWelcomeMessage() {
        String response = controller.getWelcomeMessage();

        assertEquals("Welcome to Employee Payroll App!", response);
    }

    @Test
    void givenEmployeeDetails_whenCreated_shouldReturnEmployee() {
        EmployeeDTO dto = new EmployeeDTO("Lisa", 2000);

        when(repository.save(any(EmployeePayrollData.class)))
                .thenAnswer(invocation -> {
                    EmployeePayrollData employee = invocation.getArgument(0);
                    employee.setId(1);
                    return employee;
                });

        EmployeePayrollData response = controller.createEmployee(dto);

        assertEquals(1, response.getId());
        assertEquals("Lisa", response.getName());
        assertEquals(2000, response.getSalary());
    }

    @Test
    void givenEmployeeId_whenFetched_shouldReturnEmployee() {
        EmployeePayrollData employee =
                new EmployeePayrollData(1, "Lisa", 2000);

        when(repository.findById(1))
                .thenReturn(Optional.of(employee));

        EmployeePayrollData response = controller.getEmployeeById(1);

        assertNotNull(response);
        assertEquals("Lisa", response.getName());
    }

    @Test
    void givenEmployees_whenFetched_shouldReturnAllEmployees() {
        List<EmployeePayrollData> employees = List.of(
                new EmployeePayrollData(1, "Lisa", 2000),
                new EmployeePayrollData(2, "John", 3000)
        );

        when(repository.findAll()).thenReturn(employees);

        List<EmployeePayrollData> response = controller.getAllEmployees();

        assertEquals(2, response.size());
    }

    @Test
    void givenEmployeeDetails_whenUpdated_shouldReturnUpdatedEmployee() {
        EmployeePayrollData employee =
                new EmployeePayrollData(1, "Lisa", 2000);

        when(repository.findById(1))
                .thenReturn(Optional.of(employee));

        when(repository.save(any(EmployeePayrollData.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        EmployeePayrollData response = controller.updateEmployee(
                1, new EmployeeDTO("John", 3000)
        );

        assertNotNull(response);
        assertEquals("John", response.getName());
        assertEquals(3000, response.getSalary());
    }

    @Test
    void givenEmployeeId_whenDeleted_shouldReturnSuccessMessage() {
        when(repository.existsById(1)).thenReturn(true);

        String response = controller.deleteEmployee(1);

        assertEquals("Employee deleted successfully", response);
        verify(repository).deleteById(1);
    }
}
