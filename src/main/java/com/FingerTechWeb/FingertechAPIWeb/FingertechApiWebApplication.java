package com.FingerTechWeb.FingertechAPIWeb;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FingertechApiWebApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(FingertechApiWebApplication.class);
		builder.headless(false).run(args);
	}

	@Bean
	public DLLLoader dllLoader() {
		return new DLLLoader();
	}

	public static class DLLLoader {

		@PostConstruct
		public void loadDLL() {
			// Carregar a DLL aqui
		}
	}
}
