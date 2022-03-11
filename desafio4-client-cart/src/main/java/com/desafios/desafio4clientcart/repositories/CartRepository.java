package com.desafios.desafio4clientcart.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desafios.desafio4clientcart.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
	
	List<Cart> findAll();
}
