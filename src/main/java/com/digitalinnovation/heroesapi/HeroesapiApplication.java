package com.digitalinnovation.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesapiApplication.class, args);
		System.out.println("Super poderes com webflux");
	}

}
