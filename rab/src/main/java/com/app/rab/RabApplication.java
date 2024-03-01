package com.app.rab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RabApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabApplication.class, args);
	}

}
