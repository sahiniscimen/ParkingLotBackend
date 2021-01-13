package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.ParkingAreaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaTest {

    ParkingArea parkingArea = new ParkingArea();

    @BeforeEach
    void setUp() {
        parkingArea.setCity("Ankara");
        parkingArea.setName("TUZLA");
        parkingArea.setCapacity(30);
        List<PriceTimeBlock> priceTimeBlockList = new ArrayList<>();
        PriceTimeBlock priceTimeBlock = new PriceTimeBlock();
        priceTimeBlock.setPrice(5);
        priceTimeBlock.setMaxHour(2);
        priceTimeBlock.setMinHour(0);
        priceTimeBlockList.add(priceTimeBlock);
        parkingArea.setPriceList(priceTimeBlockList);
    }

    @Test
    void whenToDTOCalledDTOFilledFromRecord() {
        ParkingAreaDTO parkingAreaDTO = parkingArea.toDTO();

        assertEquals(parkingAreaDTO.getCapacity(), parkingArea.getCapacity());
        assertEquals(parkingAreaDTO.getName(), parkingArea.getName());
        assertEquals(parkingAreaDTO.getCity(), parkingArea.getCity());
        assertEquals(parkingAreaDTO.getPriceListDTO().get(0).getPrice(), parkingArea.getPriceList().get(0).getPrice());
        assertEquals(parkingAreaDTO.getPriceListDTO().get(0).getMinHour(), parkingArea.getPriceList().get(0).getMinHour());
        assertEquals(parkingAreaDTO.getPriceListDTO().get(0).getMaxHour(), parkingArea.getPriceList().get(0).getMaxHour());

    }

    @Test
    void whenFromDTOCalledRecordFilledFromDTO() {
        ParkingAreaDTO parkingAreaDTO = parkingArea.toDTO();
        ParkingArea parkingAreaWillBeTested = new ParkingArea();
        parkingAreaWillBeTested.fromDTO(parkingAreaDTO);

        assertEquals(parkingAreaWillBeTested.getCapacity(), parkingArea.getCapacity());
        assertEquals(parkingAreaWillBeTested.getName(), parkingArea.getName());
        assertEquals(parkingAreaWillBeTested.getCity(), parkingArea.getCity());
        assertEquals(parkingAreaWillBeTested.getPriceList().get(0).getPrice(), parkingArea.getPriceList().get(0).getPrice());
        assertEquals(parkingAreaWillBeTested.getPriceList().get(0).getMinHour(), parkingArea.getPriceList().get(0).getMinHour());
        assertEquals(parkingAreaWillBeTested.getPriceList().get(0).getMaxHour(), parkingArea.getPriceList().get(0).getMaxHour());

    }

}