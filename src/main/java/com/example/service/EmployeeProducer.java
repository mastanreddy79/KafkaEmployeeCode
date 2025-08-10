package com.example.service;

import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProducer
{

    @Autowired
    private  KafkaTemplate<String, Employee> kafkaTemplate;

    private static final String TOPIC = "employee-topic";

    public void sendEmployee(Employee employee)
    {
        kafkaTemplate.send(TOPIC,employee);
        System.out.println("Sent message: " + employee.getEmpName());

    }


}
