package br.com.fastpizza.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fastpizza.entity")
@ComponentScan(basePackages = "br.com.fastpizza")
@EnableJpaRepositories("br.com.fastpizza.repository")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@PropertySource("classpath:/exception.properties")
public class FastPizzaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastPizzaApiApplication.class, args);
	}

}
