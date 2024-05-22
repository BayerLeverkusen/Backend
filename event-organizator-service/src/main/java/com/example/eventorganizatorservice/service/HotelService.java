package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.dtos.HotelDto;
import com.example.eventorganizatorservice.dtos.HotelRequest;
import com.example.eventorganizatorservice.dtos.HotelReservationRequest;
import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.model.PlayingField;
import com.example.eventorganizatorservice.model.Reservations;
import com.example.eventorganizatorservice.model.Resource;
import com.example.eventorganizatorservice.repository.HotelRepository;
import com.example.eventorganizatorservice.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<HotelDto> getAllHotels(String hotelRequest) {
        List<Hotel> hotels = hotelRepository.findAllByCity(hotelRequest);
        return hotels.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    public void reserveHotel(HotelReservationRequest hotelReservationRequest) {

        Hotel hotel = hotelRepository.findByName(hotelReservationRequest.resourceName);
        int hotelId = hotel.getId();
        Resource resource = new Resource();
        resource.setId(hotelId);
        Reservations reservations = new Reservations(hotelReservationRequest.startDate,hotelReservationRequest.endDate,hotelReservationRequest.type, resource);
        reservationsRepository.save(reservations);
    }

    public List<HotelDto> getAll() {
        List<Hotel> fields = hotelRepository.findAll();
        return fields.stream().map(this::convertToDto).collect(Collectors.toList());

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
