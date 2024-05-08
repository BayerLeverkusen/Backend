package com.example.eventorganizatorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private String hotelName;
    private String hotelCity;
    private String hotelCountry;
    private double hotelPrice;
    private double hotelRating;

}
