package sportmanagmentservice.example.sportmanagmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sportmanagmentservice.example.sportmanagmentservice.service.InitialDataInsertionService;

@SpringBootApplication
public class SportManagmentServiceApplication implements CommandLineRunner, WebMvcConfigurer {
	@Autowired
	private InitialDataInsertionService initialDataInsertionService;

	public static void main(String[] args) {
		SpringApplication.run(SportManagmentServiceApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		initialDataInsertionService.insertInitialData();
	}

}
