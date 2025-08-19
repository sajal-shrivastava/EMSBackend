package com.test.org.ems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int emplId;
    private String firstName;
    private String lastName;
    private String location;
}
