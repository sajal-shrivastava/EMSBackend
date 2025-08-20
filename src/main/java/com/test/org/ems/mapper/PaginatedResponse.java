package com.test.org.ems.mapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import com.test.org.ems.model.Employee;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse {
    private List<Employee> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}

