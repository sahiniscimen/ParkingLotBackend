package com.parking.lot.backend.interfaces;

import com.parking.lot.backend.dto.CheckInRequestDTO;
import com.parking.lot.backend.dto.CheckOutRequestDTO;
import com.parking.lot.backend.exception.OutOfPriceRangeException;
import com.parking.lot.backend.exception.ParkingAreaCapacityIsFullException;


public interface CheckInOutRecordServiceInterface {
    void checkIn(CheckInRequestDTO checkInRequestDTO) throws ParkingAreaCapacityIsFullException;
    double checkOut(CheckOutRequestDTO checkOutRequestDTO) throws OutOfPriceRangeException;
}
