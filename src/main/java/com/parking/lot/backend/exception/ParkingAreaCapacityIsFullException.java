package com.parking.lot.backend.exception;

public class ParkingAreaCapacityIsFullException extends  Exception{
    public ParkingAreaCapacityIsFullException(String message) {
        super(message);
    }

    public ParkingAreaCapacityIsFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
