package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.dtos.HotelDto;
import com.example.eventorganizatorservice.dtos.HotelReservationRequest;
import com.example.eventorganizatorservice.model.*;
import com.example.eventorganizatorservice.repository.ReservationsRepository;
import com.example.eventorganizatorservice.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<HotelDto> getAllTransports(String hotelRequest) {
        List<Transport> transports = transportRepository.findAllByCity(hotelRequest);
        return transports.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    public void reserveTransport(HotelReservationRequest hotelReservationRequest) {

        Transport transport = transportRepository.findByName(hotelReservationRequest.resourceName);
        int transportId = transport.getId();
        Resource resource = new Resource();
        resource.setId(transportId);
        Reservations reservations = new Reservations(hotelReservationRequest.startDate,hotelReservationRequest.endDate,hotelReservationRequest.type, resource);
        reservationsRepository.save(reservations);
    }

    public List<HotelDto> getAll() {
        List<Transport> fields = transportRepository.findAll();
        return fields.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    private HotelDto convertToDto(Transport transport) {
        return HotelDto.builder()
                .hotelName(transport.getName())
                .hotelCity(transport.getCity())
                .hotelCountry(transport.getCountry())
                .hotelPrice(transport.getPrice())
                .hotelRating(transport.getRating())
                .build();
    }

}
