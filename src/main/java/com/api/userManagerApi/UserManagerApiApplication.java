package com.api.userManagerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagerApiApplication.class, args);
	}

}
