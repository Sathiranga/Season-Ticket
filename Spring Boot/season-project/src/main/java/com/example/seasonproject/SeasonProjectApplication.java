package com.example.seasonproject;

import com.example.seasonproject.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class SeasonProjectApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {

		SpringApplication.run(SeasonProjectApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){

		senderService.sendEmail(
				"dulangakithulgoda06@gmail.com",
				"This is subject",
				"This is body of the email");
	}

	@Configuration
	public class CorsConfig {

		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/api/**")
							.allowedOrigins("http://localhost:3000")
							.allowedMethods("GET", "POST", "PUT", "DELETE");
				}
			};
		}
	}

}
