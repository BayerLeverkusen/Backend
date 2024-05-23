package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.dtos.HotelDto;
import com.example.eventorganizatorservice.dtos.HotelRequest;
import com.example.eventorganizatorservice.dtos.HotelReservationRequest;
import com.example.eventorganizatorservice.model.*;
import com.example.eventorganizatorservice.repository.HotelRepository;
import com.example.eventorganizatorservice.repository.PlayingFieldRepository;
import com.example.eventorganizatorservice.repository.ReservationsRepository;
import com.example.eventorganizatorservice.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldService {

    @Autowired
    private PlayingFieldRepository fieldRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<HotelDto> getAllFields(String hotelRequest) {
        List<PlayingField> fields = fieldRepository.findAllByCity(hotelRequest);
        return fields.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    public void reserveField(HotelReservationRequest hotelReservationRequest) {

        PlayingField field = fieldRepository.findByName(hotelReservationRequest.resourceName);
        int fieldId = field.getId();
        Resource resource = new Resource();
        resource.setId(fieldId);
        Reservations reservations = new Reservations(hotelReservationRequest.startDate,hotelReservationRequest.endDate,hotelReservationRequest.type, resource);
        reservationsRepository.save(reservations);
    }

    public List<HotelDto> getAll() {
        List<PlayingField> fields = fieldRepository.findAll();
        return fields.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    private HotelDto convertToDto(PlayingField field) {
        return HotelDto.builder()
                .hotelName(field.getName())
                .hotelCity(field.getCity())
                .hotelCountry(field.getCountry())
                .hotelPrice(field.getPrice())
                .hotelRating(field.getRating())
                .build();
    }

}
