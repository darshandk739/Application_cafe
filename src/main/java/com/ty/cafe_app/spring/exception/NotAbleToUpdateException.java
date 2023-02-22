package com.ty.cafe_app.spring.exception;

public class NotAbleToUpdateException extends RuntimeException{

	private String message= "No Able To Update In The Database";
	@Override
	public String getMessage() {
		return message;
	}
	public NotAbleToUpdateException(String message) {
		super();
		this.message = message;
	}
	public NotAbleToUpdateException() {
		super();
	}
}
