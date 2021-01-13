package com.parking.lot.backend.interfaces;

import com.parking.lot.backend.dto.DailyIncomeRequestDTO;
import com.parking.lot.backend.dto.ParkingAreaDTO;
import com.parking.lot.backend.exception.PriceListNotValidException;

public interface ParkingAreaServiceInterface {
    void createParkingArea(ParkingAreaDTO parkingAreaDTO) throws PriceListNotValidException;
    void updateParkingArea(ParkingAreaDTO parkingAreaDTO);
    void deleteParkingArea(ParkingAreaDTO parkingAreaDTO);
    ParkingAreaDTO getParkingAreaByName(String parkingAreaName);
    double getDailyIncomeOfParkingArea(DailyIncomeRequestDTO dailyIncomeRequestDTO);
}
