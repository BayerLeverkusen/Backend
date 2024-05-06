package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.dtos.HotelDto;
import com.example.eventorganizatorservice.dtos.HotelRequest;
import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDto> getAllHotels(String hotelRequest) {
        List<Hotel> hotels = hotelRepository.findAllByCity(hotelRequest);
        return hotels.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    private HotelDto convertToDto(Hotel hotel) {
        return HotelDto.builder()
                .hotelName(hotel.getName())
                .hotelCity(hotel.getCity())
                .hotelCountry(hotel.getCountry())
                .hotelPrice(hotel.getPrice())
                .hotelRating(hotel.getRating())
                .build();
    }

}
