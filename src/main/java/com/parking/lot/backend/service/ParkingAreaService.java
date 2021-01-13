package com.parking.lot.backend.service;


import com.parking.lot.backend.dao.CheckInOutRecordDAO;
import com.parking.lot.backend.dao.ParkingAreaDAO;
import com.parking.lot.backend.dto.DailyIncomeRequestDTO;
import com.parking.lot.backend.dto.ParkingAreaDTO;
import com.parking.lot.backend.dto.PriceTimeBlockDTO;
import com.parking.lot.backend.entity.CheckInOutRecord;
import com.parking.lot.backend.entity.ParkingArea;
import com.parking.lot.backend.exception.PriceListNotValidException;
import com.parking.lot.backend.interfaces.ParkingAreaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingAreaService implements ParkingAreaServiceInterface {
    @Autowired
    private ParkingAreaDAO parkingAreaDAO;
    @Autowired
    private CheckInOutRecordDAO checkInOutRecordDAO;

    @Override
    public void createParkingArea(ParkingAreaDTO parkingAreaDTO) throws PriceListNotValidException{
        priceListValidation(parkingAreaDTO.getPriceListDTO());
        parkingAreaDAO.save(new ParkingArea().fromDTO(parkingAreaDTO));
    }

    @Override
    public void updateParkingArea(ParkingAreaDTO parkingAreaDTO) {
        parkingAreaDAO.save(new ParkingArea().fromDTO(parkingAreaDTO));
    }

    @Override
    public void deleteParkingArea(ParkingAreaDTO parkingAreaDTO) {
        parkingAreaDAO.delete(new ParkingArea().fromDTO(parkingAreaDTO));
    }
    @Override
    public ParkingAreaDTO getParkingAreaByName(String name){
            return parkingAreaDAO.findById(name).get().toDTO();
    }

    @Override
    public double getDailyIncomeOfParkingArea(DailyIncomeRequestDTO dailyIncomeRequestDTO) {
        List<CheckInOutRecord> recordList = checkInOutRecordDAO.findByParkingAreaNameAndCheckInDate
                (dailyIncomeRequestDTO.getParkingAreaName(), dailyIncomeRequestDTO.getCheckInDate());
        Double dailyIncome =
                recordList.stream().map(CheckInOutRecord::getFee).collect(Collectors.summingDouble(Double::doubleValue));

        return dailyIncome.doubleValue();
    }

    private void priceListValidation(List<PriceTimeBlockDTO> priceTimeBlockDTOList) throws PriceListNotValidException {
        int[] priceRange = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (PriceTimeBlockDTO priceTimeBlockDTO : priceTimeBlockDTOList) {
            for (int i = 0; i < priceTimeBlockDTO.getMaxHour() - priceTimeBlockDTO.getMinHour(); i++)
                priceRange[priceTimeBlockDTO.getMinHour() + i] = 1;
        }

        if (Arrays.stream(priceRange).sum() != 24)
            throw new PriceListNotValidException("PriceList does not cover the price range for 24 hours");

    }



}
