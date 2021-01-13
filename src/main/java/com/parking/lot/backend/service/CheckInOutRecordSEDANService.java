package com.parking.lot.backend.service;

import com.parking.lot.backend.dao.CheckInOutRecordDAO;
import com.parking.lot.backend.dao.ParkingAreaDAO;
import com.parking.lot.backend.dao.VehicleDAO;
import com.parking.lot.backend.dto.CheckInRequestDTO;
import com.parking.lot.backend.dto.CheckOutRequestDTO;
import com.parking.lot.backend.entity.CheckInOutRecord;
import com.parking.lot.backend.entity.ParkingArea;
import com.parking.lot.backend.entity.PriceTimeBlock;
import com.parking.lot.backend.entity.Vehicle;
import com.parking.lot.backend.exception.OutOfPriceRangeException;
import com.parking.lot.backend.exception.ParkingAreaCapacityIsFullException;
import com.parking.lot.backend.interfaces.CheckInOutRecordServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class CheckInOutRecordSEDANService implements CheckInOutRecordServiceInterface {

    @Autowired
    public CheckInOutRecordDAO checkInOutRecordDAO;

    @Autowired
    public VehicleDAO vehicleDAO;

    @Autowired
    public ParkingAreaDAO parkingAreaDAO;

    @Override
    public void checkIn(CheckInRequestDTO checkInRequestDTO) throws ParkingAreaCapacityIsFullException {
        ParkingArea parkingArea = parkingAreaDAO.findById(checkInRequestDTO.getParkingAreaName()).get();

        if (parkingArea.getCapacity() == 0)
            throw new ParkingAreaCapacityIsFullException("ParkingArea is full.");

        CheckInOutRecord checkInOutRecord = new CheckInOutRecord();
        checkInOutRecord.fromDTO(checkInRequestDTO);
        checkInOutRecordDAO.save(checkInOutRecord);

        vehicleDAO.save(new Vehicle().fromDTO(checkInRequestDTO.getVehicleDTO()));

        parkingArea.setCapacity(parkingArea.getCapacity() - 1);
        parkingAreaDAO.save(parkingArea);

    }
    @Override
    public double checkOut(CheckOutRequestDTO checkOutRequestDTO) throws OutOfPriceRangeException {

        CheckInOutRecord record = checkInOutRecordDAO.findLastCheckInByLicencePlate(checkOutRequestDTO.getVehicleDTO().getLicencePlate());

        ParkingArea parkingArea = parkingAreaDAO.findById(checkOutRequestDTO.getParkinAreaName()).get();

        List<PriceTimeBlock> priceTimeBlockList = parkingArea.getPriceList();

        record.setFee(calculateFee(priceTimeBlockList,record.getCheckInDate(), checkOutRequestDTO.getCheckOutDate()));
        record.setCheckOutDate(checkOutRequestDTO.getCheckOutDate());

        checkInOutRecordDAO.save(record);

        parkingArea.setCapacity(parkingArea.getCapacity() + 1);

        parkingAreaDAO.save(parkingArea);

        return record.getFee();
    }

    public double calculateFee(List<PriceTimeBlock> priceTimeBlockList, Date checkInDate, Date checkOutDate) throws OutOfPriceRangeException {
        return 1;
    }
}
