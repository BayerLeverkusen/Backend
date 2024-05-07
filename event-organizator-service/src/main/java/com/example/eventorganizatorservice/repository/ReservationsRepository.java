package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Reservations;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository {

    Reservations save(Reservations reservations);

    Reservations findById(long id);


}
