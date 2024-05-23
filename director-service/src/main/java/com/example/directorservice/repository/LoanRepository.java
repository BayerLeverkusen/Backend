package com.example.directorservice.repository;

import com.example.directorservice.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

    Loan save(Loan loan);
}
