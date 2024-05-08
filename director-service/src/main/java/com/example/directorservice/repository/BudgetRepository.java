package com.example.directorservice.repository;

import com.example.directorservice.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Integer> {
    Budget save(Budget budget);
}
