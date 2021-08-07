package com.springframework.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springframework.security.repository.UserDetailRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDetailRepo.class)
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

}
