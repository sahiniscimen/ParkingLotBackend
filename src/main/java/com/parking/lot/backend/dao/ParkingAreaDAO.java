package com.parking.lot.backend.dao;

import com.parking.lot.backend.entity.ParkingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingAreaDAO extends JpaRepository<ParkingArea,String> {
}
