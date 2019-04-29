package com.newlight77.kata.bank.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException(String message) {
        super(message);
    }
}
