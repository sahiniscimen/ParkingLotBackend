package com.parking.lot.backend.controller;

import com.parking.lot.backend.dto.DailyIncomeRequestDTO;
import com.parking.lot.backend.dto.ParkingAreaDTO;
import com.parking.lot.backend.exception.PriceListNotValidException;
import com.parking.lot.backend.service.ParkingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/ParkingAreaController")
@ResponseBody
@RestController
public class ParkingAreaController {
    private ParkingAreaService parkingAreaService;

    @Autowired
    public ParkingAreaController(ParkingAreaService parkingAreaService) {
        this.parkingAreaService = parkingAreaService;
    }

    @GetMapping("/getParkingAreaByName")
    public ParkingAreaDTO getParkingAreaByName(@RequestParam String name) {
        return parkingAreaService.getParkingAreaByName(name);
    }

    @PostMapping("/createParkingArea")
    public void createParkingArea(@RequestBody ParkingAreaDTO parkingAreaDTO) throws PriceListNotValidException {
        parkingAreaService.createParkingArea(parkingAreaDTO);
    }

    @PutMapping("/updateParkingArea")
    public void updateParkingArea(@RequestBody ParkingAreaDTO parkingAreaDTO) {
        parkingAreaService.updateParkingArea(parkingAreaDTO);
    }

    @DeleteMapping("/deleteParkingArea")
    public void deleteParkingArea(@RequestBody ParkingAreaDTO parkingAreaDTO) {
        parkingAreaService.deleteParkingArea(parkingAreaDTO);
    }

    @PostMapping("/getDailyIncomeByNameAndDate")
    public double getDailyIncomeByNameAndDate(@RequestBody DailyIncomeRequestDTO dailyIncomeRequestDTO) {
        return parkingAreaService.getDailyIncomeOfParkingArea(dailyIncomeRequestDTO);
    }
}
