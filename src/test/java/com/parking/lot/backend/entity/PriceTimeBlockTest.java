package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.PriceTimeBlockDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTimeBlockTest {

    PriceTimeBlock priceTimeBlock = new PriceTimeBlock();

    @BeforeEach
    void setUp() {
        priceTimeBlock.setPrice(5);
        priceTimeBlock.setMinHour(2);
        priceTimeBlock.setMaxHour(0);
    }

    @Test
    void whenToDTOCalledDTOFilledFromRecord() {
        PriceTimeBlockDTO priceTimeBlockDTO = priceTimeBlock.toDTO();

        assertEquals(priceTimeBlockDTO.getPrice(), priceTimeBlock.getPrice());
        assertEquals(priceTimeBlockDTO.getMinHour(), priceTimeBlock.getMinHour());
        assertEquals(priceTimeBlockDTO.getMaxHour(), priceTimeBlock.getMaxHour());
    }

    @Test
    void whenFromDTOCalledRecordFilledFromDTO() {
        PriceTimeBlockDTO priceTimeBlockDTO = priceTimeBlock.toDTO();
        PriceTimeBlock priceTimeBlockWillBeTested = new PriceTimeBlock();
        priceTimeBlockWillBeTested.fromDTO(priceTimeBlockDTO);

        assertEquals(priceTimeBlockWillBeTested.getPrice(), priceTimeBlock.getPrice());
        assertEquals(priceTimeBlockWillBeTested.getMinHour(), priceTimeBlock.getMinHour());
        assertEquals(priceTimeBlockWillBeTested.getMaxHour(), priceTimeBlock.getMaxHour());
    }
}