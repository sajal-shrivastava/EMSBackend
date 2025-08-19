package com.test.org.ems.service;

import com.test.org.ems.model.Employee;
import com.test.org.ems.repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testFindAllEmployees() {
        Employee emp1 = new Employee(1, "John", "Doe", "NY");
        Employee emp2 = new Employee(2, "Jane", "Smith", "LA");
        List<Employee> mockList = Arrays.asList(emp1, emp2);
        when(employeeRepo.findAll()).thenReturn(mockList);
        List<Employee> result = employeeService.findAllEmployees();
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());
        verify(employeeRepo, times(1)).findAll();
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee(3, "Alice", "Brown", "SF");
        when(employeeRepo.save(emp)).thenReturn(1);
        int result = employeeService.addEmployee(emp);
        assertEquals(1, result);
        verify(employeeRepo, times(1)).save(emp);
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee(1, "John", "Doe", "NY");
        when(employeeRepo.update(emp)).thenReturn(1);
        int result = employeeService.updateEmployee(emp);
        assertEquals(1, result);
        verify(employeeRepo, times(1)).update(emp);
    }

    @Test
    void testDeleteEmployee() {
        when(employeeRepo.deleteById(1)).thenReturn(1);
        int result = employeeService.deleteEmployee(1);
        assertEquals(1, result);
        verify(employeeRepo, times(1)).deleteById(1);
    }

    @Test
    void testGetEmployeeById() {
        Employee emp = new Employee(1, "John", "Doe", "NY");
        when(employeeRepo.getEmployeeById(1)).thenReturn(emp);
        Employee result = employeeService.getEmployeeById(1);
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(employeeRepo, times(1)).getEmployeeById(1);
    }
}
