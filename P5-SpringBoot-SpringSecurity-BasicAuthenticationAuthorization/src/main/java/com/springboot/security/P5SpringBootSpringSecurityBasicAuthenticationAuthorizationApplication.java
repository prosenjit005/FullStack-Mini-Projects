package com.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class P5SpringBootSpringSecurityBasicAuthenticationAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(P5SpringBootSpringSecurityBasicAuthenticationAuthorizationApplication.class, args);
	}

}
