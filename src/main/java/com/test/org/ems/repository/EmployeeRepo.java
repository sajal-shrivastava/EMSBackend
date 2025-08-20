package com.test.org.ems.repository;

import com.test.org.ems.mapper.EmployeeDataMapper;
import com.test.org.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    public List<Employee> findEmployeeWithPagination(int page, int size){
        int offset = page * size;
        String sql = "Select * from employee LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new Object[]{size, offset}, new EmployeeDataMapper());
    }

    public int getTotalCount(){
        String sql = "SELECT count(*) from employee";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
