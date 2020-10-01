package com.phone.number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PhoneNumberProviderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneNumberProviderApiApplication.class, args);
	}

}
