package com.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Amit Raut
 */
@SpringBootApplication
@EnableJpaAuditing
public class CustManagementApp {

	public static void main(String[] args) {
		SpringApplication.run(CustManagementApp.class, args);
	}
}
