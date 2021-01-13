package com.parking.lot.backend.interfaces;

import com.parking.lot.backend.dto.CheckInOutRecordDTO;

import java.util.List;

public interface VehicleServiceInterface {
    List<CheckInOutRecordDTO> getParkingDetails(String licencePlate);
}
