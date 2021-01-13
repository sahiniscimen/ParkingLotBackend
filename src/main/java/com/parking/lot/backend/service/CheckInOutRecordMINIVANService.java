package com.parking.lot.backend.service;

import com.parking.lot.backend.entity.PriceTimeBlock;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CheckInOutRecordMINIVANService extends CheckInOutRecordSEDANService {

    @Override
    public double calculateFee(List<PriceTimeBlock> priceTimeBlockList, Date checkInDate, Date checkOutDate){
        return 1.15;
    }
}
