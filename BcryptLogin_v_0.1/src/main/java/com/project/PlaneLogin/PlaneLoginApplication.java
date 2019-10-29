package com.project.PlaneLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {
		"com.project"
})

public class PlaneLoginApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlaneLoginApplication.class, args);
	}

}
