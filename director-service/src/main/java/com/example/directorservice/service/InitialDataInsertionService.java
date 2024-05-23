package com.example.directorservice.service;

import com.example.directorservice.model.FinancialStatement;
import com.example.directorservice.repository.FinancialStatementRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class InitialDataInsertionService
{
    @Autowired
    private FinancialStatementRepository financialStatementRepository;

    @PostConstruct
    public void InsertData()
    {
        FinancialStatement record1 = new FinancialStatement(new Date(2023, 1, 1), 100, 200);
        FinancialStatement record2 = new FinancialStatement(new Date(2022, 2, 2), 150, 250);
        FinancialStatement record3 = new FinancialStatement(new Date(2021, 3, 3), 200, 300);
        FinancialStatement record4 = new FinancialStatement(new Date(2020, 4, 4), 250, 350);
        FinancialStatement record5 = new FinancialStatement(new Date(2019, 5, 5), 600, 0);

        List<FinancialStatement> initialRecords = Arrays.asList(record1, record2, record3, record4, record5);

        financialStatementRepository.saveAll(initialRecords);
    }
}
