package com.example.controller;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController
{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeProducer employeeProducer;

    @PostMapping("/saveEmp")
    public void addEmployee(@RequestBody Employee employee)
    {
         employeeProducer.sendEmployee(employee);

    }

    @GetMapping("/empDetails")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

}
