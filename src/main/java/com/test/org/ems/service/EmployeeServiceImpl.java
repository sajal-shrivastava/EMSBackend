package com.test.org.ems.service;

import com.test.org.ems.model.Employee;
import com.test.org.ems.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo emplRepo;


    @Override
    public List<Employee> findAllEmployees() {
        return emplRepo.findAll();
    }

    @Override
    public int addEmployee(Employee empl) {
       return emplRepo.save(empl);
    }

    @Override
    public int updateEmployee(Employee empl) {
        return emplRepo.update(empl);
    }

    @Override
    public int deleteEmployee(int id) {
        return emplRepo.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return emplRepo.getEmployeeById(id);
    }
}
