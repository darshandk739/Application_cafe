package com.ty.cafe_app.spring.exception;

public class NoSuchIdFoundException extends RuntimeException{

	private String message= "No Such Id Found In the Database";
	@Override
	public String getMessage() {
		return message;
	}
	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}
	public NoSuchIdFoundException() {
		super();
	}
	
}

