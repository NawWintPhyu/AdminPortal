package com.neurogine.adminportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan("com.neurogine.adminportal")
@OpenAPIDefinition(info = @Info(title = "AdminPortal API", version = "1.0"))

public class AdminPortalApp {

	/*
	 * Run Swagger UI 
	 * http://localhost:8080/swagger-ui/index.html
	 */
	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApp.class, args);
	}
}
