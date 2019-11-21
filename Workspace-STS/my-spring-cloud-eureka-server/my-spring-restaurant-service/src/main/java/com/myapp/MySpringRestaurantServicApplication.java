package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MySpringRestaurantServicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringRestaurantServicApplication.class, args);
	}

}
