package com.example.PayementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class PayementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayementServiceApplication.class, args);
	}

}
