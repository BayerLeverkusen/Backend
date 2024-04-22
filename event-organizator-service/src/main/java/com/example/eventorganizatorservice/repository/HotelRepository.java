package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {


    Optional<Hotel> findById(Integer integer);

    Optional<Hotel> findByName(String name);

    Optional<Hotel> findAllByCity (String city);

    Optional<Hotel> findAllByCountry (String country);

}
