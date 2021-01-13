package com.parking.lot.backend.exception;

public class PriceListNotValidException extends Exception{
    public PriceListNotValidException(String message) {
        super(message);
    }

    public PriceListNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
