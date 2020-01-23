package com.gofluent.shopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice // if any exception will come to any controller then it'll come to here.
public class ApiException {

	@ExceptionHandler(value=ProcessException.class)// when ever any ProcessException will reach to controller then that will get redirect to here.
	public ResponseEntity<Object> handleProcessException(ProcessException ex) {
		
		return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=CustomException.class)// when ever any CustomException will reach to controller then that will get redirect to here. 
	public ResponseEntity<Object> handleCustomException(CustomException ex) {
		
		return new ResponseEntity<Object>(ex, HttpStatus.ALREADY_REPORTED);
	}
}
