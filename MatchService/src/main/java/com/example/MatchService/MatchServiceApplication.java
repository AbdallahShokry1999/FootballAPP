package com.example.MatchService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // 🔴 REQUIRED TO DETECT FEIGN CLIENTS
public class MatchServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MatchServiceApplication.class, args);
	}
}
