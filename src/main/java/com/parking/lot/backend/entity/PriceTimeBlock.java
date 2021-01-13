package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.PriceTimeBlockDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PRICE_TIME_BLOCK")
public class PriceTimeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MIN_HOUR")
    private int minHour;
    @Column(name = "MAX_HOUR")
    private int maxHour;
    @Column(name = "PRICE")
    private int price;

    public PriceTimeBlockDTO toDTO(){
        PriceTimeBlockDTO priceTimeBlockDTO = new PriceTimeBlockDTO();
        priceTimeBlockDTO.setPrice(this.getPrice());
        priceTimeBlockDTO.setMinHour(this.getMinHour());
        priceTimeBlockDTO.setMaxHour(this.getMaxHour());
        return priceTimeBlockDTO;
    }

    public PriceTimeBlock fromDTO(PriceTimeBlockDTO priceTimeBlockDTO){
        this.setMinHour(priceTimeBlockDTO.getMinHour());
        this.setMaxHour(priceTimeBlockDTO.getMaxHour());
        this.setPrice(priceTimeBlockDTO.getPrice());
        return this;
    }
}

