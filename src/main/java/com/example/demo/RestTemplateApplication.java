package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan()
public class RestTemplateApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("start");
		
		System.out.println("end");
		
	}

}
