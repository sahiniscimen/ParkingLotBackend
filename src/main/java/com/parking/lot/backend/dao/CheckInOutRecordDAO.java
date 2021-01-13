package com.parking.lot.backend.dao;

import com.parking.lot.backend.entity.CheckInOutRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CheckInOutRecordDAO extends JpaRepository<CheckInOutRecord,Long> {
    List<CheckInOutRecord> findByLicencePlate(String licencePlate);
    List<CheckInOutRecord> findByParkingAreaName(String parkingAreaName);
    List<CheckInOutRecord> findByParkingAreaNameAndCheckInDate(String parkingAreaName, Date checkInDate);
    @Query("SELECT C FROM CheckInOutRecord C WHERE C.licencePlate = :licencePlate AND C.checkOutDate IS NULL AND C.fee = 0")
    CheckInOutRecord findLastCheckInByLicencePlate(@Param("licencePlate") String licencePlate);
}
