package com.parking.lot.backend.exception;

public class CheckOutRequestValidationException extends Exception{

    public CheckOutRequestValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckOutRequestValidationException(String message) {
        super(message);
    }
}
