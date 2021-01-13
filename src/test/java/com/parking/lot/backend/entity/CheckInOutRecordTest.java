package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.CheckInOutRecordDTO;
import com.parking.lot.backend.dto.CheckInRequestDTO;
import com.parking.lot.backend.dto.CheckOutRequestDTO;
import com.parking.lot.backend.dto.VehicleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CheckInOutRecordTest {
    CheckInOutRecord checkInOutRecord = new CheckInOutRecord();

    @BeforeEach
    void setUp() {
        checkInOutRecord.setCheckOutDate(Date.valueOf(LocalDate.now()));
        checkInOutRecord.setCheckInDate(Date.valueOf(LocalDate.now()));
        checkInOutRecord.setLicencePlate("33DY253");
        checkInOutRecord.setParkingAreaName("TUZLA");
        checkInOutRecord.setFee(25.6);
    }

    @Test
    void whenToDTOCalledDTOFilledFromRecord() {
        CheckInOutRecordDTO checkInOutRecordDTO = checkInOutRecord.toDTO();
        assertEquals(checkInOutRecordDTO.getId(), checkInOutRecord.getId());
        assertEquals(checkInOutRecordDTO.getCheckInDate(), checkInOutRecord.getCheckInDate());
        assertEquals(checkInOutRecordDTO.getCheckOutDate(), checkInOutRecord.getCheckOutDate());
        assertEquals(checkInOutRecordDTO.getLicencePlate(), checkInOutRecord.getLicencePlate());
        assertEquals(checkInOutRecordDTO.getParkingAreaName(), checkInOutRecord.getParkingAreaName());
        assertEquals(checkInOutRecordDTO.getFee(), checkInOutRecord.getFee());
    }

    @Test
    void whenFromDTOCalledRecordFilledFromDTO() {
        CheckInRequestDTO checkInRequestDTO = new CheckInRequestDTO();
        checkInRequestDTO.setCheckInDate(checkInOutRecord.getCheckInDate());
        checkInRequestDTO.setParkingAreaName(checkInOutRecord.getParkingAreaName());
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleType(VehicleType.SEDAN);
        vehicleDTO.setLicencePlate("33DY253");
        checkInRequestDTO.setVehicleDTO(vehicleDTO);

        CheckInOutRecord checkInOutRecordWillBeTested = new CheckInOutRecord();
        checkInOutRecordWillBeTested.fromDTO(checkInRequestDTO);

        assertEquals(checkInOutRecordWillBeTested.getCheckInDate(), checkInOutRecord.getCheckInDate());
        assertEquals(checkInOutRecordWillBeTested.getLicencePlate(), checkInOutRecord.getLicencePlate());
        assertEquals(checkInOutRecordWillBeTested.getParkingAreaName(), checkInOutRecord.getParkingAreaName());

    }
}