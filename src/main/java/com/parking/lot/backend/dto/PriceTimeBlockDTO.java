package com.parking.lot.backend.dto;

import lombok.Data;

@Data
public class PriceTimeBlockDTO {
    private int minHour;
    private int maxHour;
    private int price;
}
