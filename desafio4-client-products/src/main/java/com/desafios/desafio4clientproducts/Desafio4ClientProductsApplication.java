package com.desafios.desafio4clientproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Desafio4ClientProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Desafio4ClientProductsApplication.class, args);
	}

}
