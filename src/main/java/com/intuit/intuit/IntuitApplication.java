package com.intuit.intuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.intuit")
public class IntuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntuitApplication.class, args);
	}

}
