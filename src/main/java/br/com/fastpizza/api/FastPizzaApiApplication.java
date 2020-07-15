package br.com.fastpizza.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "br.com.fastpizza.api", exclude = {SecurityAutoConfiguration.class})
@EntityScan(basePackages = "br.com.fastpizza.entity")
@ComponentScan(basePackages = "br.com.fastpizza")
@EnableJpaRepositories("br.com.fastpizza.repository")
@PropertySource("classpath:/exception.properties")
public class FastPizzaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastPizzaApiApplication.class, args);
	}

}
