package com.parking.lot.backend.entity;

import com.parking.lot.backend.dto.CheckInOutRecordDTO;
import com.parking.lot.backend.dto.CheckInRequestDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "CHECK_IN_OUT_RECORD")
public class CheckInOutRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "CHECK_IN_DATE")
    private Date checkInDate;
    @Column(name = "CHECK_OUT_DATE")
    private Date checkOutDate;
    @NonNull
    @Column(name = "LICENCE_PLATE")
    private String licencePlate;
    @NonNull
    @Column(name = "PARKING_AREA_NAME")
    private String parkingAreaName;
    @Column(name = "FEE")
    private double fee;

    public CheckInOutRecordDTO toDTO() {
        CheckInOutRecordDTO checkInOutRecordDTO = new CheckInOutRecordDTO();
        checkInOutRecordDTO.setId(this.getId());
        checkInOutRecordDTO.setCheckInDate(this.getCheckInDate());
        checkInOutRecordDTO.setCheckOutDate(this.getCheckOutDate());
        checkInOutRecordDTO.setLicencePlate(this.getLicencePlate());
        checkInOutRecordDTO.setParkingAreaName(this.getParkingAreaName());
        checkInOutRecordDTO.setFee(this.getFee());
        return checkInOutRecordDTO;
    }

    public CheckInOutRecord fromDTO(CheckInRequestDTO checkInRequestDTO){
        this.setCheckInDate(checkInRequestDTO.getCheckInDate());
        this.setLicencePlate(checkInRequestDTO.getVehicleDTO().getLicencePlate());
        this.setParkingAreaName(checkInRequestDTO.getParkingAreaName());
        return this;
    }

}
