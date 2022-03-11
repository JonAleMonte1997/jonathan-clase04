package com.desafios.desafio4clientcart.repositories;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desafios.desafio4clientcart.entities.Product;


@FeignClient(name = "microservice-products", url = "http://localhost:2222")
public interface ProductFeingRepository {

	@RequestMapping(value = "/api/v1/products/allByIds", method = RequestMethod.GET)
	List<Product> findAllProductsByIds(@RequestBody List<Integer> ids);
}
