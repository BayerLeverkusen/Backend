package com.example.marketingmanagerservice;

import com.example.marketingmanagerservice.service.InitialDataInsertionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MarketingManagerServiceApplication implements CommandLineRunner, WebMvcConfigurer {

	@Autowired
	private InitialDataInsertionService initialDataInsertionService;

	public static void main(String[] args) {
		SpringApplication.run(MarketingManagerServiceApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		initialDataInsertionService.insertInitialData();
	}
}
