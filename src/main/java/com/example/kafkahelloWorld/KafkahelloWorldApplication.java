package com.example.kafkahelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages ="com.example.model")
@EnableJpaRepositories(basePackages = "com.example.repository")
@ComponentScan(basePackages = {"com.example.controller", "com.example.service"})
public class KafkahelloWorldApplication
{
	public static void main(String[] args)
    {
        SpringApplication.run(KafkahelloWorldApplication.class, args);
        System.out.println("Apache kafaka server is running");

	}

}
