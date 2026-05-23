package com.example.RESTusingSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ResTusingSpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ResTusingSpringbootApplication.class, args);
		System.out.println("hello world");
	}
}
