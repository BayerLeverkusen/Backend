package com.example.eventorganizatorservice.repository;

import com.example.eventorganizatorservice.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {

}
