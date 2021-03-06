package com.cgrdev.springbootrestcrudapijpa.dao;

import com.cgrdev.springbootrestcrudapijpa.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(Employee employee);
}
