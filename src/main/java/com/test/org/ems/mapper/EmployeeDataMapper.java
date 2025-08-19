package com.test.org.ems.mapper;

import com.test.org.ems.model.Employee;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class EmployeeDataMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp = new Employee(rs.getInt("empid"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("location"));
        return emp;
    }

}
