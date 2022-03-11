package com.desafios.desafio4clientproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio4clientproducts.entities.Product;
import com.desafios.desafio4clientproducts.exceptions.NotFoundException;
import com.desafios.desafio4clientproducts.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAllProducts() {
		
		return productRepository.findAll();
	}
	
	public List<Product> findAllProductsByIds(List<Integer> ids) {
		
		return (List<Product>)productRepository.findAllById(ids);
	}
	
	public Product findProductById(Integer id) {
		
		Optional<Product> optionalProduct = productRepository.findById(id);
		
		if (!optionalProduct.isPresent()) {
			throw new NotFoundException();
		}
		
		return optionalProduct.get(); 
	}
	
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product, Integer id) {
		
		Product productToUpdate = findProductById(id);
		
		productToUpdate.setName(product.getName());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		
		return productRepository.save(productToUpdate);
	}
	
	public void deleteProduct(Integer id) {
		
		Product productToDelete = findProductById(id);
		
		productRepository.delete(productToDelete);
	}
}
