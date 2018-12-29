package com.syw.dao;

import com.syw.pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    void update(Employee employee);
    void delete(Integer id);
    List<Employee> query();
    Employee queryById(Integer id);
}
