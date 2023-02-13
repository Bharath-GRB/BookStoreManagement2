package com.cg.exception;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String string) {
		super(string);
	}

}
