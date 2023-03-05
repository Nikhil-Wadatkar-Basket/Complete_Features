package com.bs.exception;

public class EmptyDepartmentList extends RuntimeException {
    public EmptyDepartmentList(String message) {
        super(message);
    }

}
