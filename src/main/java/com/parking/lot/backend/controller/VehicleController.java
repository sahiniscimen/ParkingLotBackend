package com.parking.lot.backend.controller;

import com.parking.lot.backend.dto.CheckInOutRecordDTO;
import com.parking.lot.backend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/VehicleController")
@ResponseBody
@RestController
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/getParkingDetailByLicencePlate")
    public List<CheckInOutRecordDTO> getParkingDetailByLicencePlate(@RequestParam String licencePlate) {
        return vehicleService.getParkingDetails(licencePlate);
    }

}
