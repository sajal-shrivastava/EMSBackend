package com.test.org.ems.repository;

import com.test.org.ems.mapper.EmployeeDataMapper;
import com.test.org.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll(){
    String sql = "Select * from employee";
    return jdbcTemplate.query(sql, new EmployeeDataMapper());
    }

    public int save(Employee empl){
        String sql = "INSERT INTO employee(empid, firstname, lastname, location) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, empl.getEmplId(), empl.getFirstName(), empl.getLastName(), empl.getLocation());
    }

    public int update(Employee employee){
    String sql = "UPDATE employee SET firstname=?, lastname=?, location=? WHERE empid=?";
    return jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getLocation(), employee.getEmplId());
    }

    public int deleteById(int id){
        String sql = "DELETE FROM employee where empId = ?";
        return jdbcTemplate.update(sql, id);
    }

    public Employee getEmployeeById(int id){
        String sql = "SELECT * FROM employee where empid=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeDataMapper());
    }

    public List<Employee> findEmployeeWithPagination(int page, int size, String location) {
        int offset = page * size;
        String sql = "";
        List<Employee> employeeList = new ArrayList<>();

        if (location == null || location.isEmpty()) {
            sql = "SELECT * FROM employee LIMIT ? OFFSET ?";
            employeeList = jdbcTemplate.query(sql, new Object[]{size, offset}, new EmployeeDataMapper());
        } else {
            sql = "SELECT * FROM employee WHERE location = ? LIMIT ? OFFSET ?";
            employeeList = jdbcTemplate.query(sql, new Object[]{location, size, offset}, new EmployeeDataMapper());
        }
        return employeeList;
    }


    public int getTotalCount(String location){
        String sql = "SELECT count(*) from employee";

        if(location != ""){
            sql = "SELECT count(*) from employee where location = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{location}, Integer.class);
        }
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<String> findAllLocations() {
        String sql = "SELECT location FROM employee";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
