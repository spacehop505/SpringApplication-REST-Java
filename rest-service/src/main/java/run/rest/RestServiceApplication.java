package run.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// define packages 
@SpringBootApplication(scanBasePackages = { "controller", "database", "model"})
public class RestServiceApplication {

	//https://start.spring.io
	
	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
