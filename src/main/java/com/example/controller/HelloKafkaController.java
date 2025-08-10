package com.example.controller;

import com.example.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloKafkaController
{
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/insert")
    public String sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return "Message sent to Kafka topic!";
    }

}
