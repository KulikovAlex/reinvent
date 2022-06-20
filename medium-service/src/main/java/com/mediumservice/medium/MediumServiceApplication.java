package com.mediumservice.medium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MediumServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumServiceApplication.class, args);
	}

}
