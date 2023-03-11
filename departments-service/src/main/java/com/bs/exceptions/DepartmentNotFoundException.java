package com.bs.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
	public DepartmentNotFoundException(String message) {
		super(message);
	}

}
