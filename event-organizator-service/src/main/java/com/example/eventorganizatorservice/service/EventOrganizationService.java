package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.repository.EventRepository;
import com.example.eventorganizatorservice.repository.HotelRepository;
import com.example.eventorganizatorservice.repository.PlayingFieldRepository;
import com.example.eventorganizatorservice.repository.TransportRepository;
import org.springframework.stereotype.Service;

@Service
public class EventOrganizationService {

    private HotelRepository hotelRepository;

    private PlayingFieldRepository playingFieldRepository;

    private EventRepository eventRepository;

    private TransportRepository transportRepository;


}
