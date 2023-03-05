package com.bs.employee.exception;

public class EmptyEmployeeList extends RuntimeException {
    public EmptyEmployeeList(String message) {
        super(message);
    }

}
