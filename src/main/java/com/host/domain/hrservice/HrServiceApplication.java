package com.host.domain.hrservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
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