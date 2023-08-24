package com.nttdata.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NttdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdataApplication.class, args);
	}

}
