package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAware")
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "Online BookStore REST API Documentation",
				description = "Online Bookstore Microservice REST API Documentation",
				version = "V1",
				contact = @Contact(
						name  = "Ayush Kumar",
						email = "ag15121998@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "www.google.com"
				)
		),
		externalDocs  = @ExternalDocumentation(
				description = "Online BookStore external API Docs",
				url = "www.google.com"
		)
)
public class OnlineBookStoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreManagementSystemApplication.class, args);
	}

}
