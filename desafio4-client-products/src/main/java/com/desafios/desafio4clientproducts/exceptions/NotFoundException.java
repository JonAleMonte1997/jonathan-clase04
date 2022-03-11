package com.desafios.desafio4clientproducts.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
        super("Producto no encontrado");
    }
}
