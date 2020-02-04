package com.rau.sentosa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice 
public class ApiException {

	@ExceptionHandler(value=ProcessException.class)
	public ResponseEntity<Object> handleProcessException(ProcessException ex) {
		
		return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=CustomException.class) 
	public ResponseEntity<Object> handleCustomException(CustomException ex) {
		
		return new ResponseEntity<Object>(ex, HttpStatus.EXPECTATION_FAILED);
	}
}
