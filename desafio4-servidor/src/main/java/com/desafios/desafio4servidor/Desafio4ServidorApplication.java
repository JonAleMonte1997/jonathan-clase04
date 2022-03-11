package com.desafios.desafio4servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Desafio4ServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Desafio4ServidorApplication.class, args);
	}

}
