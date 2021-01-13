package com.parking.lot.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CheckInRequestDTO {
    private Date checkInDate;
    private VehicleDTO vehicleDTO;
    private String parkingAreaName;
}
