package com.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.netflix.discovery.DiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
 