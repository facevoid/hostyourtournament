package com.webproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.webproject.repository")
@SpringBootApplication

public class HostyourtournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostyourtournamentApplication.class, args);
	}
}
