package com.gasbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GasBookingApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(GasBookingApplication.class, args);
		
	}

}
