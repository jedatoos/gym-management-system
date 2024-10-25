package com.betek.gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class gymApplication {

	public static void main(String[] args) {
		SpringApplication.run(gymApplication.class, args);
	}

}
