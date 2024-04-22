package com.example.eventorganizatorservice;

import com.example.eventorganizatorservice.service.InitialDataInsertionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class EventOrganizatorServiceApplication implements CommandLineRunner {

	InitialDataInsertionService initialDataInsertionService;

	public static void main(String[] args) {
		SpringApplication.run(EventOrganizatorServiceApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		initialDataInsertionService.insertInitialData();

	}

}
