package com.parking.lot.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CheckOutRequestDTO {
    private Date checkOutDate;
    private VehicleDTO vehicleDTO;
    private String parkinAreaName;
}
