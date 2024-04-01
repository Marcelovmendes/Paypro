package br.com.marcelovmendes.paybackend;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableRabbit
@EnableJdbcAuditing
@SpringBootApplication
public class PayBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayBackendApplication.class, args);
	}

}
