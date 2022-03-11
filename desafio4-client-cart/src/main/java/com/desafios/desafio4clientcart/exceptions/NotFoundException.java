package com.desafios.desafio4clientcart.exceptions;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
        super("Producto no encontrado");
    }
}
