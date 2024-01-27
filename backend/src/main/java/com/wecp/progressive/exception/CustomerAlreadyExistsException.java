package com.wecp.progressive.exception;

public class CustomerAlreadyExistsException extends Exception{

    public CustomerAlreadyExistsException() {
    }

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
    
}