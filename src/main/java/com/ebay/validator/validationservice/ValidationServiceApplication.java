package com.ebay.validator.validationservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Locale;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ValidationServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ValidationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("service started...");
	}
}
