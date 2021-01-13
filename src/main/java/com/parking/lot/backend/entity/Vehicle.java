package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.VehicleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @Column(name = "LICENCE_PLATE")
    private String licencePlate;
    @Column(name = "VEHICLE_TYPE")
    private VehicleType vehicleType;

    public VehicleDTO toDTO(){
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setLicencePlate(this.getLicencePlate());
        vehicleDTO.setVehicleType(this.getVehicleType());
        return vehicleDTO;
    }

    public Vehicle fromDTO(VehicleDTO vehicleDTO){
        this.setLicencePlate(vehicleDTO.getLicencePlate());
        this.setVehicleType(vehicleDTO.getVehicleType());
        return this;
    }
}

