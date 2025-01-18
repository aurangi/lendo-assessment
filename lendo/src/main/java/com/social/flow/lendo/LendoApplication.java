package com.social.flow.lendo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LendoApplication {

	public static void main(String[] args) {

		SpringApplication.run(LendoApplication.class, args);

	}

}


