package com.example.app;	

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemositeApplication.class, args);
	}

}
