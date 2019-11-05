package com.jorgealcinoneto.technicalchallenge.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TechnicalChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalChallengeApplication.class, args);
	}

}
