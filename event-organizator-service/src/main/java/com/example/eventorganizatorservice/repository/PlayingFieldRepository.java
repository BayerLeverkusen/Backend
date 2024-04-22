package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.PlayingField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayingFieldRepository extends JpaRepository<PlayingField, Integer> {

    Optional<PlayingField> findById(Integer id);

    Optional<PlayingField> findByName(String name);

    Optional<PlayingField> findAllByCity (String city);

    Optional<PlayingField> findAllByCountry (String country);
}
