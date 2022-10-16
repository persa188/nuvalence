package com.nuvalence.rectangles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RectanglesApplication {
	Logger logger = LoggerFactory.getLogger(RectanglesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RectanglesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			logger.info("Running Nuvalence DEMO Application");
		};
	}
}
