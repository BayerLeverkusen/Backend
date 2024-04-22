package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findByName(String name);
    Event findById(int id);
    Event findByNameAndId(String name, Integer id);

}
