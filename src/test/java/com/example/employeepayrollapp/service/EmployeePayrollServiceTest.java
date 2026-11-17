
package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeePayrollServiceTest {

    @Mock
    private EmployeePayrollRepository repository;

    @InjectMocks
    private EmployeePayrollService service;

    @Test
    void givenEmployeeDetails_whenAdded_shouldReturnEmployee() {

        EmployeeDTO dto = new EmployeeDTO("Lisa", 2000);

        when(repository.save(any(EmployeePayrollData.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        EmployeePayrollData employee = service.addEmployee(dto);

        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());

        verify(repository, times(1)).save(any(EmployeePayrollData.class));
    }

    @Test
    void givenEmployeeId_whenFetched_shouldReturnEmployee() {

        EmployeePayrollData employee =
                new EmployeePayrollData(1, "Lisa", 2000);

        when(repository.findById(1)).thenReturn(Optional.of(employee));

        EmployeePayrollData result = service.getEmployeeById(1);

        assertNotNull(result);
        assertEquals("Lisa", result.getName());
    }

    @Test
    void givenEmployeeDetails_whenUpdated_shouldUpdateEmployee() {

        EmployeePayrollData employee =
                new EmployeePayrollData(1, "Lisa", 2000);

        when(repository.findById(1)).thenReturn(Optional.of(employee));
        when(repository.save(any(EmployeePayrollData.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        EmployeePayrollData result =
                service.updateEmployee(1, new EmployeeDTO("John", 3000));

        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals(3000, result.getSalary());
    }

    @Test
    void givenEmployeeId_whenDeleted_shouldRemoveEmployee() {

        when(repository.existsById(1)).thenReturn(true);

        boolean result = service.deleteEmployee(1);

        assertTrue(result);
        verify(repository, times(1)).deleteById(1);
    }
}
