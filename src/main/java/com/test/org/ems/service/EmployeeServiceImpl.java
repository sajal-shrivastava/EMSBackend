package com.test.org.ems.service;

import com.test.org.ems.mapper.PaginatedResponse;
import com.test.org.ems.model.Employee;
import com.test.org.ems.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo emplRepo;


    @Override
    public List<Employee> findAllEmployees() {
        log.info("Service: findAllEmployees called");
        return emplRepo.findAll();
    }

    @Override
    public int addEmployee(Employee empl) {
        log.info("Service: addEmployee called with {}", empl);
       return emplRepo.save(empl);
    }

    @Override
    public int updateEmployee(Employee empl) {
        log.info("Service: updateEmployee called with {}", empl);
        return emplRepo.update(empl);
    }

    @Override
    public int deleteEmployee(int id) {
        log.info("Service: deleteEmployee called with id {}", id);
        return emplRepo.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        log.info("Service: getEmployeeById called with id {}", id);
        return emplRepo.getEmployeeById(id);
    }

    @Override
    public PaginatedResponse getPaginatedResponse(int page, int size, String location) {
        List<Employee> employees = emplRepo.findEmployeeWithPagination(page, size, location);
        int count = emplRepo.getTotalCount(location);
        int totalPages = (int) Math.ceil((double) count / size);

        return new PaginatedResponse(employees, page, size, count, totalPages);

    }

    @Override
    public List<String> findAllLocations() {
        return emplRepo.findAllLocations();
    }


}
