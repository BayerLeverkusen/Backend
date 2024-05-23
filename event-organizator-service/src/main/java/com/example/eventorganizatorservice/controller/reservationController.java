package com.example.eventorganizatorservice.controller;

import com.example.eventorganizatorservice.dtos.*;
import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.model.Reservations;
import com.example.eventorganizatorservice.service.HotelService;
import com.example.eventorganizatorservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class reservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationsDto>> getAllUsers() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/get")
    public ResponseEntity<Optional<Hotel>> getAll() {
        return ResponseEntity.ok(reservationService.getAllR());
    }

    @DeleteMapping("/delete")
    public void deleteReservation(@RequestBody delRequest delRequests) {
        reservationService.deleteRes(delRequests);
    }

    @PatchMapping
    public void modifyReservation(@RequestBody ModRequest modRequests) {

    }

}
