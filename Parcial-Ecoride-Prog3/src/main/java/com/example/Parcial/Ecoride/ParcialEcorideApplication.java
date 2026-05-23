package com.example.Parcial.Ecoride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class ParcialEcorideApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcialEcorideApplication.class, args);
	}
}
