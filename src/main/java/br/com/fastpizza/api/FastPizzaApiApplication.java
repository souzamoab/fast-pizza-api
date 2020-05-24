package br.com.fastpizza.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fastpizza.entity")
public class FastPizzaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastPizzaApiApplication.class, args);
	}

}
