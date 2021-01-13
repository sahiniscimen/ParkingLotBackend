package com.parking.lot.backend.dao;

import com.parking.lot.backend.entity.ParkingArea;
import com.parking.lot.backend.entity.PriceTimeBlock;
import com.parking.lot.backend.exception.AlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ParkingAreaDAOTest {

    ParkingAreaDAO parkingAreaDAO = Mockito.mock(ParkingAreaDAO.class);

    @BeforeEach
    void setUp() {

    }

    @Test
    void whenParkAreaCreatedAfterWillBeFindable() {
        List<PriceTimeBlock> priceTimeBlockList = new ArrayList<>();
        priceTimeBlockList.add(mockPriceTimeBlock(5, 0,12));
        priceTimeBlockList.add(mockPriceTimeBlock(10, 12,24));

        when(parkingAreaDAO.findById("TUZLA")).thenReturn(
                Optional.of(mockParkingArea("TUZLA", 20, "İSTANBUL", priceTimeBlockList)));

        ParkingArea parkingAreaWillBeTested = mockParkingArea("TUZLA", 20, "İSTANBUL", priceTimeBlockList);

        parkingAreaDAO.save(parkingAreaWillBeTested);

        assertCompare(parkingAreaDAO.findById("TUZLA").get(), parkingAreaWillBeTested);
    }

    ParkingArea mockParkingArea(String name, int capacity, String city, List<PriceTimeBlock> priceTimeBlockList){
        ParkingArea parkingArea = new ParkingArea();
        parkingArea.setName(name);
        parkingArea.setCapacity(capacity);
        parkingArea.setCity(city);
        parkingArea.setPriceList(priceTimeBlockList);
        return  parkingArea;
    }

    PriceTimeBlock mockPriceTimeBlock(int price, int minHour, int maxHour){
        PriceTimeBlock priceTimeBlock = new PriceTimeBlock();
        priceTimeBlock.setPrice(price);
        priceTimeBlock.setMinHour(minHour);
        priceTimeBlock.setMaxHour(maxHour);
        return priceTimeBlock;
    }

    private void assertCompare(ParkingArea parkingArea, ParkingArea parkingAreaWillBeTested) {
        assertEquals(parkingArea.getName(), parkingAreaWillBeTested.getName());
        assertEquals(parkingArea.getCapacity(), parkingAreaWillBeTested.getCapacity());
        assertEquals(parkingArea.getCity(), parkingAreaWillBeTested.getCity());
        for(int i = 0; i < parkingArea.getPriceList().size(); i++)
            assertEquals(parkingArea.getPriceList().get(i), parkingAreaWillBeTested.getPriceList().get(i));
    }

}


