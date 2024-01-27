package com.wecp.progressive.exception;

public class WithdrawalLimitException extends Exception {

    public WithdrawalLimitException() {
    }

    public WithdrawalLimitException(String message) {
        super(message);
    }
    
}