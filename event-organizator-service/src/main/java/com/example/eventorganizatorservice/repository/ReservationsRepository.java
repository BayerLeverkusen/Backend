package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.model.Reservations;
import com.example.eventorganizatorservice.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends CrudRepository<Reservations, Integer> {

    Reservations save(Reservations reservations);

    List<Reservations> findAll();

    Reservations findById(int id);

    void deleteById(int id);

   // void updateById(int id, Reservations reservations);
}
