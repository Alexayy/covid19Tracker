package com.aleksa.covid19_status_reporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19StatusReporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19StatusReporterApplication.class, args);
	}

}
