package com.example.eventorganizatorservice.controller;

import com.example.eventorganizatorservice.dtos.HotelDto;
import com.example.eventorganizatorservice.dtos.HotelRequest;
import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class hotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/getAll")
    public ResponseEntity<List<HotelDto>> getAllUsers(@RequestBody HotelRequest request) {
        return ResponseEntity.ok(hotelService.getAllHotels(request));
    }


}
