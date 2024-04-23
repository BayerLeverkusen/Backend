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

        Hotel hotel1 = new Hotel("Hotel Arts Barcelona", "Spain", "Barcelona", "Marina 19-21", 300.00,4);
        Hotel hotel2 = new Hotel("W Barcelona", "Spain", "Barcelona", "Plaça de la Rosa dels Vents, 1", 250.00,4.6);
        Hotel hotel3 = new Hotel("Hotel SB Icaria Barcelona", "Spain", "Barcelona", "Avinguda Icaria, 195", 150.00,3.7);
        Hotel hotel4 = new Hotel("Hilton Diagonal Mar Barcelona", "Spain", "Barcelona", "Passeig del Taulat, 262-264", 200.00,3.4);
        Hotel hotel5 = new Hotel("Hotel Novotel Barcelona City", "Spain", "Barcelona", "Avenida Diagonal 201", 180.00,4.4);

        Hotel hotel6 = new Hotel("Hotel Leverkusen", "Germany", "Leverkusen", "Bismarckstraße 118", 150.00,4.6);
        Hotel hotel7 = new Hotel("Holiday Inn Express Cologne - Troisdorf", "Germany", "Leverkusen", "Echternacher Str. 4", 120.00,4.2);
        Hotel hotel8 = new Hotel("Ibis Budget Koeln Leverkusen City", "Germany", "Leverkusen", "Lichstr. 72", 90.00,4.0);
        Hotel hotel9 = new Hotel("Best Western Leoso Hotel Leverkusen", "Germany", "Leverkusen", "Am Büchelter Hof 11", 180.00,3.9);
        Hotel hotel10 = new Hotel("Hotel Sechzehn", "Germany", "Leverkusen", "Bahnstr. 16", 100.00,3.6);


        PlayingField field1 = new PlayingField("Camp Nou", "Spain", "Barcelona", "Carrer d'Aristides Maillol, 12", true,4.3);
        PlayingField field2 = new PlayingField("Parc de la Ciutadella", "Spain", "Barcelona", "Passeig de Picasso, s/n", true,3.8);
        PlayingField field3 = new PlayingField("Montjuic Olympic Stadium", "Spain", "Barcelona", "Passeig Olímpic, 17-19", true,4.8);
        PlayingField field4 = new PlayingField("Barcelona Beach", "Spain", "Barcelona", "Barceloneta Beach", true,3.2);
        PlayingField field5 = new PlayingField("Tibidabo Amusement Park", "Spain", "Barcelona", "Placa del Tibidabo, 3-4", true,4.2);

        PlayingField field6 = new PlayingField("BayArena", "Germany", "Leverkusen", "Bismarckstraße 118", false,3);
        PlayingField field7 = new PlayingField("Sportplatz Kruppstrasse", "Germany", "Leverkusen", "Kruppstrasse 68", false,3);
        PlayingField field8 = new PlayingField("Sportanlage Birkenberg", "Germany", "Leverkusen", "Lindemannstrasse 30", false,3);
        PlayingField field9 = new PlayingField("Sportheim Wiembachtal", "Germany", "Leverkusen", "Mühlheimer Straße 137", false,3);
        PlayingField field10 = new PlayingField("Sportanlage Manforter Straße", "Germany", "Leverkusen", "Manforter Straße 189", false,3);


        Transport transport1 = new Transport("Barcelona El Prat Airport", "Spain", "Barcelona", "Avinguda de l'Aeroport, s/n", 30.00,3.8);
        Transport transport2 = new Transport("Sagrada Familia", "Spain", "Barcelona", "Carrer de Mallorca, 401", 15.00,3.4);
        Transport transport3 = new Transport("Barcelona Sants Station", "Spain", "Barcelona", "Placa dels Paisos Catalans, 1", 25.00,4.6);
        Transport transport4 = new Transport("Park Guell", "Spain", "Barcelona", "Carrer d'Olot, s/n", 20.00,3.2);
        Transport transport5 = new Transport("Barcelona Zoo", "Spain", "Barcelona", "Parc de la Ciutadella", 10.00,4.9);

        Transport transport6 = new Transport("Cologne Bonn Airport", "Germany", "Leverkusen", "Kennedystraße, 51147 Köln", 30.00,4.9);
        Transport transport7 = new Transport("Leverkusen Mitte", "Germany", "Leverkusen", "Friedrich-Ebert-Platz 1, 51373 Leverkusen", 10.00,4.6);
        Transport transport8 = new Transport("Leverkusen Schlebusch", "Germany", "Leverkusen", "Bismarckstraße 28, 51373 Leverkusen", 10.00,4.2);
        Transport transport9 = new Transport("Leverkusen Küppersteg", "Germany", "Leverkusen", "Düsseldorfer Straße 53, 51379 Leverkusen", 10.00,3.9);
        Transport transport10 = new Transport("Leverkusen Rheindorf", "Germany", "Leverkusen", "Wilhelm-Gräfrath-Straße 1, 51371 Leverkusen", 10.00,3.3);


        hotelRepository.save(hotel1);
        hotelRepository.save(hotel2);
        hotelRepository.save(hotel3);
        hotelRepository.save(hotel4);
        hotelRepository.save(hotel5);
        hotelRepository.save(hotel6);
        hotelRepository.save(hotel7);
        hotelRepository.save(hotel8);
        hotelRepository.save(hotel9);
        hotelRepository.save(hotel10);

        playingFieldRepository.save(field1);
        playingFieldRepository.save(field2);
        playingFieldRepository.save(field3);
        playingFieldRepository.save(field4);
        playingFieldRepository.save(field5);
        playingFieldRepository.save(field6);
        playingFieldRepository.save(field7);
        playingFieldRepository.save(field8);
        playingFieldRepository.save(field9);
        playingFieldRepository.save(field10);

        transportRepository.save(transport1);
        transportRepository.save(transport2);
        transportRepository.save(transport3);
        transportRepository.save(transport4);
        transportRepository.save(transport5);
        transportRepository.save(transport6);
        transportRepository.save(transport7);
        transportRepository.save(transport8);
        transportRepository.save(transport9);
        transportRepository.save(transport10);
    }
}
