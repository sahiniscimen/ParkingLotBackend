package com.parking.lot.backend.dao;

import com.parking.lot.backend.entity.CheckInOutRecord;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CheckInOutRecordDAOTest {


    CheckInOutRecordDAO checkInOutRecordDAO = Mockito.mock(CheckInOutRecordDAO.class);

    @BeforeEach
    void setUp() {
        List<CheckInOutRecord> checkInOutRecordList = new ArrayList<>();
        checkInOutRecordList.add(mockRecord("33DY253", "TUZLA", 25.6));

        when(checkInOutRecordDAO.findByLicencePlate("33DY253")).thenReturn(checkInOutRecordList);

        checkInOutRecordList.add(mockRecord("33BD144", "TUZLA", 27.6));

        when(checkInOutRecordDAO.findByParkingAreaNameAndCheckInDate("TUZLA", checkInOutRecordList.get(0).getCheckInDate())).thenReturn(checkInOutRecordList);
        when(checkInOutRecordDAO.findByParkingAreaNameAndCheckInDate("TUZLA", checkInOutRecordList.get(1).getCheckInDate())).thenReturn(checkInOutRecordList);

        when(checkInOutRecordDAO.findLastCheckInByLicencePlate("33DY253")).thenReturn(mockRecord("33DY253", "KADIKÖY", 27.6));


    }

    @Test
    void whenRecordSavedAfterWillBeFindable(){
        CheckInOutRecord recordWillBeTested =  mockRecord("33DY253", "TUZLA", 25.6);
        checkInOutRecordDAO.save(recordWillBeTested);

        CheckInOutRecord checkInOutRecordWillBeTested =
                checkInOutRecordDAO.findByLicencePlate(
                        recordWillBeTested.getLicencePlate()
                ).get(0);

        assertCompare(checkInOutRecordWillBeTested, recordWillBeTested);
    }

    @Test
    void whenRecordsSavedAfterWillBeFindableAsListWithParkingAreaNameAndDate() {
        CheckInOutRecord checkInOutRecord1 = mockRecord("33DY253", "TUZLA", 25.6);
        checkInOutRecordDAO.save(checkInOutRecord1);

        CheckInOutRecord checkInOutRecord2 = mockRecord("33BD144", "TUZLA", 27.6);
        checkInOutRecordDAO.save(checkInOutRecord2);


        CheckInOutRecord checkInOutRecordWillBeTested1 =
                checkInOutRecordDAO.findByParkingAreaNameAndCheckInDate(
                        checkInOutRecord1.getParkingAreaName(), checkInOutRecord1.getCheckInDate()
                ).get(0);


        CheckInOutRecord checkInOutRecordWillBeTested2 =
                checkInOutRecordDAO.findByParkingAreaNameAndCheckInDate(
                        checkInOutRecord1.getParkingAreaName(), checkInOutRecord1.getCheckInDate()
                ).get(1);


        assertCompare(checkInOutRecordWillBeTested1, checkInOutRecord1);
        assertCompare(checkInOutRecordWillBeTested2, checkInOutRecord2);

    }

    @Test
    void whenTwoRecordsSavedTheRecentOneWillBeFindableByLicencePlate() {
        CheckInOutRecord checkInOutRecord1 = mockRecord("33DY253", "TUZLA", 25.6);
        checkInOutRecordDAO.save(checkInOutRecord1);

        CheckInOutRecord checkInOutRecord2 = mockRecord("33DY253", "KADIKÖY", 27.6);
        checkInOutRecordDAO.save(checkInOutRecord2);

        CheckInOutRecord checkInOutRecordWillBeTested =
                checkInOutRecordDAO.findLastCheckInByLicencePlate(checkInOutRecord2.getLicencePlate());

        assertCompare(checkInOutRecordWillBeTested, checkInOutRecord2);
    }

    private CheckInOutRecord mockRecord(String licencePlate, String parkingAreaName, Double fee){
        CheckInOutRecord checkInOutRecord = new CheckInOutRecord();
        checkInOutRecord.setCheckOutDate(Date.valueOf(LocalDate.now()));
        checkInOutRecord.setCheckInDate(Date.valueOf(LocalDate.now()));
        checkInOutRecord.setLicencePlate(licencePlate);
        checkInOutRecord.setParkingAreaName(parkingAreaName);
        checkInOutRecord.setFee(fee);
        return  checkInOutRecord;
    }

    private void assertCompare(CheckInOutRecord record1, CheckInOutRecord record2){
        assertEquals(record1.getCheckInDate(), record2.getCheckInDate());
        assertEquals(record1.getCheckOutDate(), record2.getCheckOutDate());
        assertEquals(record1.getLicencePlate(), record2.getLicencePlate());
        assertEquals(record1.getParkingAreaName(), record2.getParkingAreaName());
        assertEquals(record1.getFee(), record2.getFee());
    }
}