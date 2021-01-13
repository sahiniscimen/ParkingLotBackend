package com.parking.lot.backend.service;

import com.parking.lot.backend.entity.PriceTimeBlock;
import com.parking.lot.backend.exception.OutOfPriceRangeException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CheckInOutRecordSUVService extends CheckInOutRecordSEDANService {
    @Override
    public double calculateFee(List<PriceTimeBlock> priceTimeBlockList, Date checkInDate, Date checkOutDate) throws OutOfPriceRangeException {
        return 1.10;
    }
}
