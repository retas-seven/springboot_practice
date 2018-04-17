package com.tuyano.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MyBootGAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBootGAppApplication.class, args);
	}
}
