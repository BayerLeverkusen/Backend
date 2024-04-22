package com.example.eventorganizatorservice.service;

import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.model.PlayingField;
import com.example.eventorganizatorservice.model.Transport;
import com.example.eventorganizatorservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitialDataInsertionService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTemplateRepository eventTemplateRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private PlayingFieldRepository playingFieldRepository;

    @Autowired
    private TransportRepository transportRepository;

    public void insertInitialData() {
        Hotel hotel = new Hotel("name","country","city","address",200);

        PlayingField playingField = new PlayingField("name", "country", "city", "address", true);

        Transport transport = new Transport("name", "country", "city", "address", 200);

        String country = "Spain";
        String city = "Barcelona";

        Hotel hotel1 = new Hotel("Hotel Arts Barcelona", "Spain", "Barcelona", "Marina 19-21", 300.00);
        Hotel hotel2 = new Hotel("W Barcelona", "Spain", "Barcelona", "Plaça de la Rosa dels Vents, 1", 250.00);
        Hotel hotel3 = new Hotel("Hotel SB Icaria Barcelona", "Spain", "Barcelona", "Avinguda Icaria, 195", 150.00);
        Hotel hotel4 = new Hotel("Hilton Diagonal Mar Barcelona", "Spain", "Barcelona", "Passeig del Taulat, 262-264", 200.00);
        Hotel hotel5 = new Hotel("Hotel Novotel Barcelona City", "Spain", "Barcelona", "Avenida Diagonal 201", 180.00);

        hotelRepository.save(hotel1);
        hotelRepository.save(hotel2);
        hotelRepository.save(hotel3);
        hotelRepository.save(hotel4);
        hotelRepository.save(hotel5);


        PlayingField field1 = new PlayingField("Camp Nou", "Spain", "Barcelona", "Carrer d'Aristides Maillol, 12", false);
        PlayingField field2 = new PlayingField("Parc de la Ciutadella", "Spain", "Barcelona", "Passeig de Picasso, s/n", false);
        PlayingField field3 = new PlayingField("Montjuic Olympic Stadium", "Spain", "Barcelona", "Passeig Olímpic, 17-19", true);
        PlayingField field4 = new PlayingField("Barcelona Beach", "Spain", "Barcelona", "Barceloneta Beach", true);
        PlayingField field5 = new PlayingField("Tibidabo Amusement Park", "Spain", "Barcelona", "Placa del Tibidabo, 3-4", true);

        playingFieldRepository.save(field1);
        playingFieldRepository.save(field2);
        playingFieldRepository.save(field3);
        playingFieldRepository.save(field4);
        playingFieldRepository.save(field5);

        Transport transport1 = new Transport("Barcelona El Prat Airport", "Spain", "Barcelona", "Avinguda de l'Aeroport, s/n", 30.00);
        Transport transport2 = new Transport("Sagrada Familia", "Spain", "Barcelona", "Carrer de Mallorca, 401", 15.00);
        Transport transport3 = new Transport("Barcelona Sants Station", "Spain", "Barcelona", "Placa dels Paisos Catalans, 1", 25.00);
        Transport transport4 = new Transport("Park Guell", "Spain", "Barcelona", "Carrer d'Olot, s/n", 20.00);
        Transport transport5 = new Transport("Barcelona Zoo", "Spain", "Barcelona", "Parc de la Ciutadella", 10.00);

        transportRepository.save(transport1);
        transportRepository.save(transport2);
        transportRepository.save(transport3);
        transportRepository.save(transport4);
        transportRepository.save(transport5);


    }
}
