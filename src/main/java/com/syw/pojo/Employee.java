package com.syw.pojo;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    private Integer age;

    public Employee() {
    }
}
