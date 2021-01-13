package com.parking.lot.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DailyIncomeRequestDTO {
    private String parkingAreaName;
    private Date checkInDate;
}
