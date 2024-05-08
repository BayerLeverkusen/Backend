package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.model.Reservations;
import com.example.eventorganizatorservice.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends CrudRepository<Hotel, Integer> {

    Reservations save(Reservations reservations);


}
