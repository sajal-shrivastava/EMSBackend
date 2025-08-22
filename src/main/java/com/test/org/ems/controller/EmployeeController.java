package com.test.org.ems.controller;

import com.test.org.ems.mapper.PaginatedResponse;
import com.test.org.ems.model.Employee;
import com.test.org.ems.service.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("http://localhost:5173")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping
    public List<Employee> findAllEmployees(){
        log.info("Fetching all employees");
        return employeeService.findAllEmployees();
    }

    @PostMapping
    public String createRecord(@RequestBody Employee empl){
        log.info("Creating employee: {}", empl);
        int result = employeeService.addEmployee(empl);
        return result == 1 ? "Employee Added" : "Request Failed";
    }

    @PutMapping
    public String updateRecord(@RequestBody Employee empl){
        log.info("Updating employee: {}", empl);
        int result = employeeService.updateEmployee(empl);
        return result == 1 ? "Employee Updated" : "Request Failed";
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable int id){
        log.info("Deleting employee with id: {}", id);
        int result = employeeService.deleteEmployee(id);
        return result == 1 ? "Employee Deleted" : "Request Failed";
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        log.info("Fetching employee by id: {}", id);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/locations")
    public List<String> getAllLocations(){
        return employeeService.findAllLocations();
    }

    @GetMapping("/page")
    public PaginatedResponse findPaginatedData(@RequestParam int page, @RequestParam int size, @RequestParam(defaultValue = "") String location){
        return employeeService.getPaginatedResponse(page,size,location);
    }

}
