package com.verizon.exceptiondemo;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String message)
	{
		super(message);
	}
}
