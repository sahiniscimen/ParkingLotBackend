package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.VehicleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Vehicle vehicle = new Vehicle();

    @BeforeEach
    void setUp() {
        vehicle.setVehicleType(VehicleType.SEDAN);
        vehicle.setLicencePlate("33DY253");
    }

    @Test
    void whenToDTOCalledDTOFilledFromRecord() {
        VehicleDTO vehicleDTO = vehicle.toDTO();

        assertEquals(vehicleDTO.getVehicleType(), vehicle.getVehicleType());
        assertEquals(vehicleDTO.getLicencePlate(), vehicle.getLicencePlate());
    }

    @Test
    void whenFromDTOCalledRecordFilledFromDTO() {
        VehicleDTO vehicleDTO = vehicle.toDTO();
        Vehicle vehicleWillBeTested = new Vehicle();
        vehicleWillBeTested.fromDTO(vehicleDTO);

        assertEquals(vehicleWillBeTested.getVehicleType(), vehicle.getVehicleType());
        assertEquals(vehicleWillBeTested.getLicencePlate(), vehicle.getLicencePlate());
    }
}