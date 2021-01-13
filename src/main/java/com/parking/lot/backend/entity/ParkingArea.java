package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.ParkingAreaDTO;
import com.parking.lot.backend.dto.PriceTimeBlockDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "PARKING_AREA")
@AllArgsConstructor
@NoArgsConstructor
public class ParkingArea{
    @Id
    @NonNull
    @Column(name = "PARKING_AREA_NAME")
    private String name;
    @Column(name = "PARKING_AREA_CAPACITY")
    private int capacity;
    @Column(name = "PARKING_AREA_CITY")
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARKING_AREA_NAME", referencedColumnName = "PARKING_AREA_NAME")
    private List<PriceTimeBlock> priceList;

    public ParkingAreaDTO toDTO(){
        ParkingAreaDTO parkingAreaDTO = new ParkingAreaDTO();
        parkingAreaDTO.setName(this.getName());
        parkingAreaDTO.setCapacity(this.getCapacity());
        parkingAreaDTO.setCity(this.getCity());
        List<PriceTimeBlockDTO> priceTimeBlockDTOList= this.getPriceList().stream().map(PriceTimeBlock::toDTO).collect(Collectors.toList());
        parkingAreaDTO.setPriceListDTO(priceTimeBlockDTOList);
        return parkingAreaDTO;
    }

    public ParkingArea fromDTO(ParkingAreaDTO parkingAreaDTO){
        this.setName(parkingAreaDTO.getName());
        this.setCapacity(parkingAreaDTO.getCapacity());
        this.setCity(parkingAreaDTO.getCity());
        List<PriceTimeBlock> priceTimeBlockList = parkingAreaDTO.getPriceListDTO().stream().map(priceTimeBlockDTO ->
        new PriceTimeBlock().fromDTO(priceTimeBlockDTO)).collect(Collectors.toList());
        this.setPriceList(priceTimeBlockList);
        return this;
    }
}
