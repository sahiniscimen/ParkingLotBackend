package com.parking.lot.backend.dao;

import com.parking.lot.backend.entity.PriceTimeBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceTimeBlockDAO extends JpaRepository<PriceTimeBlock,Long> {
}
