package com.example.eventorganizatorservice.controller;

import com.example.eventorganizatorservice.dtos.HotelDto;
import com.example.eventorganizatorservice.dtos.HotelReservationRequest;
import com.example.eventorganizatorservice.service.FieldService;
import com.example.eventorganizatorservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/field")
public class fieldController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private FieldService fieldService;

    @GetMapping("/getAll")
    public ResponseEntity<List<HotelDto>> getAllUsers(String city) {
        return ResponseEntity.ok(fieldService.getAllFields(city));
    }

    @PostMapping("/reserve")
    public void reserveHotel(@RequestBody HotelReservationRequest hotelReservationRequest) {

        fieldService.reserveField(hotelReservationRequest);
    }

    @GetMapping("/get")
    public ResponseEntity<List<HotelDto>> getAll(){
        return ResponseEntity.ok(fieldService.getAll());
    }

}