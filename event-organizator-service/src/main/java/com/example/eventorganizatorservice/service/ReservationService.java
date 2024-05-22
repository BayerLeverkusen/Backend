package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.dtos.ReservationsDto;
import com.example.eventorganizatorservice.model.*;
import com.example.eventorganizatorservice.repository.HotelRepository;
import com.example.eventorganizatorservice.repository.PlayingFieldRepository;
import com.example.eventorganizatorservice.repository.ReservationsRepository;
import com.example.eventorganizatorservice.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private PlayingFieldRepository playingFieldRepository;

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<ReservationsDto> getAllReservations() {
        List<ReservationsDto> dtos = new ArrayList<>();
        for (Reservations reservation : reservationsRepository.findAll()) {
            ReservationsDto dto = new ReservationsDto();

            Optional<Hotel> hotel = hotelRepository.findById(reservation.getId());
            Optional<PlayingField> playingField = playingFieldRepository.findById(reservation.getId());
            Optional<Transport> transport = transportRepository.findById(reservation.getId());

            dto.setReservationHotelId(reservation.getId());
           // dto.setReservationHotelName(hotel.get().getName());
           // dto.setReservationHotelCountry(hotel.get().getCountry());
           // dto.setReservationHotelCity(hotel.get().getCity());
           // dto.setReservationHotelPrice(hotel.get().getPrice());
            dto.setReservationHotelStartDate(reservation.getStartDate());
            dto.setReservationHotelEndDate(reservation.getEndDate());


            dto.setReservationTransportId(reservation.getId());
           // dto.setReservationTransportName(transport.get().getName());
          //  dto.setReservationTransportCountry(transport.get().getCountry());
          //  dto.setReservationTransportCity(transport.get().getCity());
          //  dto.setReservationTransportPrice(transport.get().getPrice());
            dto.setReservationTransportStartDate(reservation.getStartDate());
            dto.setReservationTransportEndDate(reservation.getEndDate());

            dto.setReservationFieldId(reservation.getId());
           // dto.setReservationFieldName(playingField.get().getName());
           // dto.setReservationFieldCountry(playingField.get().getCountry());
           // dto.setReservationFieldCity(playingField.get().getCity());
           // dto.setReservationFieldPrice(playingField.get().getPrice());
            dto.setReservationFieldStartDate(reservation.getStartDate());
            dto.setReservationFieldEndDate(reservation.getEndDate());



            dtos.add(dto);
        }
        return dtos;
    }

    public Optional<Hotel> getAllR() {
        Optional<Hotel> hotel = hotelRepository.findById(2);
        return hotel;
    }

    public void getHotel(){

    }

    public void getField(){

    }

    public void getTransport(){

    }

   /* private ReservationsDto convertToDto(Reservations reservations) {
        return HotelDto.builder()
                .hotelName(reservations.getName())
                .hotelCity(reservations.getCity())
                .hotelCountry(reservations.getCountry())
                .hotelPrice(reservations.getPrice())
                .hotelRating(reservations.getRating())
                .build();
    }*/

}
