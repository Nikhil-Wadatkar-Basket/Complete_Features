package com.bs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyDepartmentList.class)
    public ResponseEntity<Object> emptyList() {
        return new ResponseEntity<>("Department list contains no records", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Object> departmentNotFoundException(DepartmentNotFoundException departmentNotFoundException) {
        return new ResponseEntity<>(departmentNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
