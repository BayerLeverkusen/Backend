package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.dtos.ModRequest;
import com.example.eventorganizatorservice.dtos.ReservationsDto;
import com.example.eventorganizatorservice.dtos.delRequest;
import com.example.eventorganizatorservice.model.*;
import com.example.eventorganizatorservice.repository.HotelRepository;
import com.example.eventorganizatorservice.repository.PlayingFieldRepository;
import com.example.eventorganizatorservice.repository.ReservationsRepository;
import com.example.eventorganizatorservice.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public void deleteRes(delRequest delRequests){

        reservationsRepository.deleteById(delRequests.getIdRH());
        reservationsRepository.deleteById(delRequests.getIdRT());
        reservationsRepository.deleteById(delRequests.getIdRF());



    }

    public void modifyRes(ModRequest modRequests){
        Reservations reservation = reservationsRepository.findById(modRequests.getResID());
        System.out.println(reservation);
        Hotel hotel = hotelRepository.findByName(modRequests.resName);

        reservation.setStartDate(modRequests.startDate);
        reservation.setEndDate(modRequests.endDate);
        reservation.setResource(hotel);


        reservationsRepository.save(reservation);
    }

    public List<ReservationsDto> getAllReservations() {
        List<ReservationsDto> dtos = new ArrayList<>();
        ReservationsDto currentDto = null;
        int reservationCount = 0;

        for (Reservations reservation : reservationsRepository.findAll()) {
            if (currentDto == null || reservationCount % 3 == 0) {
                currentDto = new ReservationsDto();
                dtos.add(currentDto);
                reservationCount = 0; // Reset the counter for the new DTO
            }

            switch (reservation.getType()) {
                case HOTEL:
                    Optional<Hotel> hotelOpt = hotelRepository.findById(reservation.getResource().id);
                    if (hotelOpt.isPresent()) {
                        Hotel hotel = hotelOpt.get();
                        currentDto.setReservationHotelId(reservation.getId());
                        currentDto.setReservationHotelName(hotel.getName());
                        currentDto.setReservationHotelCountry(hotel.getCountry());
                        currentDto.setReservationHotelCity(hotel.getCity());
                        currentDto.setReservationHotelPrice(hotel.getPrice());
                        currentDto.setReservationHotelStartDate(reservation.getStartDate());
                        currentDto.setReservationHotelEndDate(reservation.getEndDate());
                    }
                    break;
                case TRANSPORT:
                    Optional<Transport> transportOpt = transportRepository.findById(reservation.getResource().id);
                    if (transportOpt.isPresent()) {
                        Transport transport = transportOpt.get();
                        currentDto.setReservationTransportId(reservation.getId());
                        currentDto.setReservationTransportName(transport.getName());
                        currentDto.setReservationTransportCountry(transport.getCountry());
                        currentDto.setReservationTransportCity(transport.getCity());
                        currentDto.setReservationTransportPrice(transport.getPrice());
                        currentDto.setReservationTransportStartDate(reservation.getStartDate());
                        currentDto.setReservationTransportEndDate(reservation.getEndDate());
                    }
                    break;
                case FIELD:
                    Optional<PlayingField> playingFieldOpt = playingFieldRepository.findById(reservation.getResource().id);
                    if (playingFieldOpt.isPresent()) {
                        PlayingField playingField = playingFieldOpt.get();
                        currentDto.setReservationFieldId(reservation.getId());
                        currentDto.setReservationFieldName(playingField.getName());
                        currentDto.setReservationFieldCountry(playingField.getCountry());
                        currentDto.setReservationFieldCity(playingField.getCity());
                        currentDto.setReservationFieldPrice(playingField.getPrice());
                        currentDto.setReservationFieldStartDate(reservation.getStartDate());
                        currentDto.setReservationFieldEndDate(reservation.getEndDate());
                    }
                    break;
                default:
                    // Handle unexpected types (optional)
            }

            reservationCount++;
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
