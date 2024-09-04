package com.host.domain.hrservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class HrServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
		System.out.println("HrServiceApplication");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
}