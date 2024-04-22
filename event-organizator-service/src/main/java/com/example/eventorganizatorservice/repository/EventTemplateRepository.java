package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.EventTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTemplateRepository extends JpaRepository<EventTemplate, Integer> {

}
