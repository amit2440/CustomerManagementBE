package com.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Amit Raut
 */
@SpringBootApplication
@EnableJpaAuditing
public class CustManagementApp implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(CustManagementApp.class, args);
	}


}
