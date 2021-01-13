package com.parking.lot.backend.service;

import com.parking.lot.backend.dao.CheckInOutRecordDAO;
import com.parking.lot.backend.dao.VehicleDAO;
import com.parking.lot.backend.dto.CheckInOutRecordDTO;
import com.parking.lot.backend.entity.CheckInOutRecord;
import com.parking.lot.backend.interfaces.VehicleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements VehicleServiceInterface {

    @Autowired
    private VehicleDAO vehicleDAO;

    @Autowired
    private CheckInOutRecordDAO checkInOutRecordDAO;

    @Override
    public List<CheckInOutRecordDTO> getParkingDetails(String licencePlate) {
        return checkInOutRecordDAO.findByLicencePlate(licencePlate).stream().map(CheckInOutRecord::toDTO).collect(Collectors.toList());
    }
}
