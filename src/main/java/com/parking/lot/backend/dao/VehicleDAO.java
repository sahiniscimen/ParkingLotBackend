package com.parking.lot.backend.dao;

import com.parking.lot.backend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle,String> {
}
