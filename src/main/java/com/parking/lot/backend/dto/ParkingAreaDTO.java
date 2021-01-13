package com.parking.lot.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class ParkingAreaDTO {
    private String name;
    private int capacity;
    private String city;
    private List<PriceTimeBlockDTO> priceListDTO;
}
