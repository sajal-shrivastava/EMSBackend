package com.test.org.ems.service;

import com.test.org.ems.mapper.PaginatedResponse;
import com.test.org.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    int addEmployee(Employee empl);
    int updateEmployee(Employee empl);
    int deleteEmployee(int id);
    Employee getEmployeeById(int id);

    PaginatedResponse getPaginatedResponse(int page, int size, String location);

    List<String> findAllLocations();

}
