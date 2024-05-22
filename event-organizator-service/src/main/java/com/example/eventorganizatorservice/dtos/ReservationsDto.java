package com.example.eventorganizatorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationsDto {
    private int reservationHotelId;
    private String reservationHotelName;
    private String reservationHotelCountry;
    private String reservationHotelCity;
    private double reservationHotelPrice;
    private LocalDate reservationHotelStartDate;
    private LocalDate reservationHotelEndDate;

    private int reservationTransportId;
    private String reservationTransportName;
    private String reservationTransportCountry;
    private String reservationTransportCity;
    private double reservationTransportPrice;
    private LocalDate reservationTransportStartDate;
    private LocalDate reservationTransportEndDate;

    private int reservationFieldId;
    private String reservationFieldName;
    private String reservationFieldCountry;
    private String reservationFieldCity;
    private double reservationFieldPrice;
    private LocalDate reservationFieldStartDate;
    private LocalDate reservationFieldEndDate;

}