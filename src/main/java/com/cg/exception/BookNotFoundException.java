package com.cg.exception;

public class BookNotFoundException extends RuntimeException{
	
	public BookNotFoundException(String string)
	{
		super(string);
	}

}
