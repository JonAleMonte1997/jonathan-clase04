package com.desafios.desafio4clientcart.entities;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Product {

	private Integer id;
	
	private String name;
	
	private Integer quantity;
	
	private BigDecimal unitPrice;

	public Product() {
	}

	public Product(Integer id, String name, Integer quantity, BigDecimal unitPrice) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}
