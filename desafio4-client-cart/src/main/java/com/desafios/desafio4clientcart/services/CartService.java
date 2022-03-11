package com.desafios.desafio4clientcart.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio4clientcart.dtos.ProductDto;
import com.desafios.desafio4clientcart.entities.Cart;
import com.desafios.desafio4clientcart.entities.Product;
import com.desafios.desafio4clientcart.exceptions.NotFoundException;
import com.desafios.desafio4clientcart.repositories.CartRepository;
import com.desafios.desafio4clientcart.repositories.ProductFeingRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductFeingRepository productFeingRepository;
	
	public List<Product> findAllProductsByIds(List<Integer> id) {
		
		return productFeingRepository.findAllProductsByIds(id);
	}
	
	public List<Cart> findAll() {
		
		return cartRepository.findAll();
	}
	
	public Cart findCartById(Integer id) {
		
		Optional<Cart> optionalCart = cartRepository.findById(id);
		
		if (!optionalCart.isPresent()) {
			throw new NotFoundException();
		}
		
		return optionalCart.get();
	}
	
	public Cart createCart(Set<ProductDto> productsDto) {
		
		List<Product> products = findAllProductsByIds(productsDto.stream().map(ProductDto::getId).collect(Collectors.toList()));
		
		for (Product product : products) {
			
			for (ProductDto productDto : productsDto) {
				
				if (product.getId().equals(productDto.getId())) {
					
					product.setQuantity(productDto.getQuantity());
					
					break;
				}
			}
		}
		
		return cartRepository.save(new Cart(calculateTotal(products), products));
	}
	
	private BigDecimal calculateTotal(List<Product> products) {
		
		return products.stream()
				.map(product -> product.getUnitPrice().multiply(new BigDecimal(product.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public Cart updateCart(Cart cart, Integer id) {
		
		Cart cartToUpdate = findCartById(id);
		
		cartToUpdate.setProducts(cart.getProducts());
		cartToUpdate.setTotal(cart.getTotal());
		
		return cartRepository.save(cartToUpdate);
	}
	
	public void deleteCart(Integer id) {
		
		Cart cartToDelete = findCartById(id);
		
		cartRepository.delete(cartToDelete);
	}
}
