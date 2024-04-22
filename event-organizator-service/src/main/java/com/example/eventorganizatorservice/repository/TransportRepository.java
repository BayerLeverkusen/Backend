package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {

    Transport save(Transport transport);

    Optional<Transport> findByName(String name);

    Optional<Transport> findById(int id);

    Iterable<Transport> findByCity(String city);

    Iterable<Transport> findByCountry(String address);


}
