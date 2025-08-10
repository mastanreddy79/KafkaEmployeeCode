package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConsumer
{

     @Autowired
     private EmployeeRepository employeeRepository;

    @KafkaListener(topics = "employee-topic", groupId = "employee-group")
    public void consume(Employee employee) {
        System.out.println("Consumed Employee: " + employee.getEmpName());
        employeeRepository.save(employee);
    }



}
