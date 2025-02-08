package com.example.PlayerStatisticsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients  // 🔴 REQUIRED TO DETECT FEIGN CLIENTS

public class PlayerStatisticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerStatisticsServiceApplication.class, args);
	}

}
