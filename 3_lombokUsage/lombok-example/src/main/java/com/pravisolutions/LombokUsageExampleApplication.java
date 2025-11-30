package com.pravisolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// This serves as the main entry point for the service

@SpringBootApplication // This annotation also take care of component scanning
public class LombokUsageExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LombokUsageExampleApplication.class, args);
	}

}
