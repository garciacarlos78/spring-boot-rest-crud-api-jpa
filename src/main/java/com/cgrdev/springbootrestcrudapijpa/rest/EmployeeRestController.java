package com.cgrdev.springbootrestcrudapijpa.rest;

import com.cgrdev.springbootrestcrudapijpa.entity.Employee;
import com.cgrdev.springbootrestcrudapijpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO Exception handling in general
//  - Correct id (0 < id < MAX_INT)

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;

    @Autowired
    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return service.getAll();
    }

    // expose "/employees/{employeeId}" and return employee with given id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return service.getOne(employeeId);
    }

    // creates a new employee using the data received in the JSON body
    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    // update existing employee
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return service.update(employee);
    }

    // delete employee by id
    // TODO Modify to not return same status code (200 OK) when deleted and when not found
    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId) {
        if (!service.delete(employeeId))
            throw new RuntimeException("Employee with id not found - " + employeeId);
        return "Employee with id deleted - " + employeeId;
    }
}
