package com.desafios.desafio4clientproducts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desafios.desafio4clientproducts.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findAll();
}
