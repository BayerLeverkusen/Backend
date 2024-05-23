package com.example.IdentityService.repository;

import com.example.IdentityService.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FanRepository extends JpaRepository<Fan, Integer> {
    boolean existsByUsername(String username);
    Fan findByUsername(String username);
}
