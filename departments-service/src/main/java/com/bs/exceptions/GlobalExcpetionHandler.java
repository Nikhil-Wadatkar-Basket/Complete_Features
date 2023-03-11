package com.bs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcpetionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> handleDepartmentNotFoundException(DepartmentNotFoundException exc) {
		return new ResponseEntity<String>(exc.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyDepartmentListException.class)
	public ResponseEntity<String> handleEmptyDepartmentListException(EmptyDepartmentListException ecx) {
		return new ResponseEntity<String>(ecx.getMessage(), HttpStatus.NOT_FOUND);
	}
}
