package com.cg.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cg.springsecurity.entity.UserRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class SpringSecurityJdbc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbc1Application.class, args);
	}

}
