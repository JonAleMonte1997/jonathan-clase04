package com.desafios.desafio4clientcart.dtos;

public class ProductDto {

	private Integer id;
	
	private Integer quantity;

	public ProductDto() {
	}

	public ProductDto(Integer id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
