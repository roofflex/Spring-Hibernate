package com.roofflex.springboot.springdatarestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestDemoApplication.class, args);
	}

}


// All the endpoints and controller are created automatically simply by adding a Spring Data Rest Dependency and Creating a JpaRepository