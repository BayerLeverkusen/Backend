package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.PlayingField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayingFieldRepository extends JpaRepository<PlayingField, Integer> {

    PlayingField save(PlayingField playingField);

    Optional<PlayingField> findById(Integer id);

    Optional<PlayingField> findByName(String name);

    Iterable<PlayingField> findAllByCity (String city);

    Iterable<PlayingField> findAllByCountry (String country);
}
