package com.avoodoo.spring.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author frank
 *
 * 
 * 
 * Error: The type org.springframework.context.ConfigurableApplicationContext cannot be resolved. It is indirectly referenced from required .class files
 * https://stackoverflow.com/questions/40086257/the-type-org-springframework-context-configurableapplicationcontext-cannot-be-re
 * 
 * mvn dependency:purge-local-repository
 * 
 */
/* 1. Annotate the Application with @SpringBootApplication */
@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		/* 2. Setup as web application */
		SpringApplication.run(CourseApiApp.class, args);
	}

}
