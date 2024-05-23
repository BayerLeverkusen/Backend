package com.example.directorservice.repository;

import com.example.directorservice.model.FinancialStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialStatementRepository extends JpaRepository<FinancialStatement,Integer>
{
    FinancialStatement save(FinancialStatement financialStatement);
}
