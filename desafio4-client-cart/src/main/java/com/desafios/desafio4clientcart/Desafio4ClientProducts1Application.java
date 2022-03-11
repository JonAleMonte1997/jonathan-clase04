package com.desafios.desafio4clientcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class Desafio4ClientProducts1Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio4ClientProducts1Application.class, args);
	}

}
