package com.desafios.desafio4clientproducts.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.desafio4clientproducts.entities.Product;
import com.desafios.desafio4clientproducts.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findAllProducts() {
		
		return productService.findAllProducts();
	}
	
	@PostMapping("/allByIds")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findAllProductsByIds(@RequestBody List<Integer> ids) {
		
		return productService.findAllProductsByIds(ids);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product findProductById(@PathVariable Integer id) {
		
		return productService.findProductById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@Valid @RequestBody Product product) {
		
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product updateProduct(@Valid @RequestBody Product product, @PathVariable Integer id) {
		
		return productService.updateProduct(product, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer id) {
		
		productService.deleteProduct(id);
	}
}
