package com.parking.lot.backend.dto;

import com.parking.lot.backend.entity.VehicleType;
import lombok.Data;

@Data
public class VehicleDTO {
    private String licencePlate;
    private VehicleType vehicleType;
}
