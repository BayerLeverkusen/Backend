package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Hotel;
import com.example.eventorganizatorservice.model.PlayingField;
import com.example.eventorganizatorservice.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {

    Transport save(Transport transport);

    Optional<Transport> findById(int id);

    Iterable<Transport> findByCity(String city);

    Iterable<Transport> findByCountry(String address);

    List<Transport> findAllByCity(String city);

    Transport findByName(String name);

    List<Transport> findAll();


}
