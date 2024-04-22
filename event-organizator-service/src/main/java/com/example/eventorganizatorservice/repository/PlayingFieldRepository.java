package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.PlayingField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayingFieldRepository extends JpaRepository<PlayingField, Long> {
}
