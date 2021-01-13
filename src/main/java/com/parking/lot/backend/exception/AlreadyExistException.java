package com.parking.lot.backend.exception;

public class AlreadyExistException extends Exception{

    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
