package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event save(Event event);

    Optional<Event> findByName(String name);

    Optional<Event> findById(int id);

}
