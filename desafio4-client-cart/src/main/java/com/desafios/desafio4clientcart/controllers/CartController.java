package com.desafios.desafio4clientcart.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.desafio4clientcart.dtos.ProductDto;
import com.desafios.desafio4clientcart.entities.Cart;
import com.desafios.desafio4clientcart.services.CartService;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cart> findAllCarts() {
		return cartService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cart findCartById(@PathVariable Integer id) {
		return cartService.findCartById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cart createCart(@RequestBody Set<ProductDto> products) {
		
		return cartService.createCart(products);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cart updateCart(@RequestBody Cart cart, @PathVariable Integer id) {
		
		return cartService.updateCart(cart, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCart(@PathVariable Integer id) {
		
		cartService.deleteCart(id);
	}
}
