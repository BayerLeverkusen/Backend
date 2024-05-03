package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    Hotel save(Hotel hotel);

    Optional<Hotel> findById(Integer integer);

    Optional<Hotel> findByName(String name);

    Iterable<Hotel> findAllByCity (String city);

    Iterable<Hotel> findAllByCountry (String country);



}
