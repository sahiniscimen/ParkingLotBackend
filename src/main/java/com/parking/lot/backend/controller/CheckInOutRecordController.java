package com.parking.lot.backend.controller;

import com.parking.lot.backend.dto.CheckInRequestDTO;
import com.parking.lot.backend.dto.CheckOutRequestDTO;
import com.parking.lot.backend.entity.VehicleType;
import com.parking.lot.backend.exception.CheckOutRequestValidationException;
import com.parking.lot.backend.exception.OutOfPriceRangeException;
import com.parking.lot.backend.exception.ParkingAreaCapacityIsFullException;
import com.parking.lot.backend.service.CheckInOutRecordMINIVANService;
import com.parking.lot.backend.service.CheckInOutRecordSEDANService;
import com.parking.lot.backend.service.CheckInOutRecordSUVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/CheckInOutRecordController")
@ResponseBody
@RestController
public class CheckInOutRecordController {
    private CheckInOutRecordSEDANService checkInOutRecordSEDANService;
    private CheckInOutRecordMINIVANService checkInOutRecordMINIVANService;
    private CheckInOutRecordSUVService checkInOutRecordSUVService;

    @Autowired
    public CheckInOutRecordController(CheckInOutRecordSEDANService checkInOutRecordSEDANService, CheckInOutRecordMINIVANService checkInOutRecordMINIVANService, CheckInOutRecordSUVService checkInOutRecordSUVService) {
        this.checkInOutRecordSEDANService = checkInOutRecordSEDANService;
        this.checkInOutRecordMINIVANService = checkInOutRecordMINIVANService;
        this.checkInOutRecordSUVService = checkInOutRecordSUVService;
    }


    @PostMapping("/CheckIn")
    public void checkIn(@RequestBody CheckInRequestDTO checkInRequestDTO) throws ParkingAreaCapacityIsFullException {
        checkInOutRecordSEDANService.checkIn(checkInRequestDTO);
    }

    @PostMapping ("/CheckOut")
    public double checkOut(@RequestBody CheckOutRequestDTO checkOutRequestDTO) throws CheckOutRequestValidationException, OutOfPriceRangeException {
        if(checkOutRequestDTO.getVehicleDTO().getLicencePlate() == null)
            throw new CheckOutRequestValidationException("LicencePlate is not valid.");
        if(checkOutRequestDTO.getVehicleDTO().getVehicleType() == VehicleType.SEDAN)
            return checkInOutRecordSEDANService.checkOut(checkOutRequestDTO);
        else if(checkOutRequestDTO.getVehicleDTO().getVehicleType() == VehicleType.SUV)
            return checkInOutRecordSUVService.checkOut(checkOutRequestDTO);
        else if(checkOutRequestDTO.getVehicleDTO().getVehicleType() == VehicleType.MINIVAN)
            return checkInOutRecordMINIVANService.checkOut(checkOutRequestDTO);
        else
            throw new CheckOutRequestValidationException("VehicleType is not valid.");
    }
}
