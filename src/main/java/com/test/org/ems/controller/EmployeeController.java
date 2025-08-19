package com.test.org.ems.controller;

import com.test.org.ems.model.Employee;
import com.test.org.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("http://localhost:5173")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PostMapping
    public String createRecord(@RequestBody Employee empl){
        int result = employeeService.addEmployee(empl);
        return result == 1 ? "Employee Added" : "Request Failed";
    }

    @PutMapping
    public String updateRecord(@RequestBody Employee empl){
        int result = employeeService.updateEmployee(empl);
        return result == 1 ? "Employee Updated" : "Request Failed";
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable int id){
        int result = employeeService.deleteEmployee(id);
        return result == 1 ? "Employee Deleted" : "Request Failed";
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

}
