package com.parking.lot.backend.exception;

public class OutOfPriceRangeException extends Exception{

    public OutOfPriceRangeException(String message) {
        super(message);
    }

    public OutOfPriceRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
