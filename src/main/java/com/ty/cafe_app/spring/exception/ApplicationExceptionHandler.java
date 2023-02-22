package com.ty.cafe_app.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.cafe_app.spring.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundHandler(NoSuchIdFoundException exception) {
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Id Found");
		responseStructure.setData(exception.getMessage());
		return responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}

	@ExceptionHandler(NotAbleToUpdateException.class)
	public ResponseEntity<ResponseStructure<String>> notAbleToUpdateHandler(NotAbleToUpdateException exception) {
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Able To Update");
		responseStructure.setData(exception.getMessage());
		return responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}

}
