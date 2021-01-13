package com.parking.lot.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CheckInOutRecordDTO {
    private Long id;
    private Date checkInDate;
    private Date checkOutDate;
    private String licencePlate;
    private String parkingAreaName;
    private double fee;
}
