package com.example.directorservice.service;

import com.example.directorservice.model.FinancialStatement;
import com.example.directorservice.repository.FinancialStatementRepository;
import com.example.directorservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialStatementService
{
    @Autowired
    private FinancialStatementRepository financialStatementRepository;

    @Autowired
    private LoanService loanService;

    public int getCurrentBalance()
    {
        return getProfit()+loanService.getActiveLoanAmmount();
    }

    public int getProfit()
    {
        int profit = 0;

        for (FinancialStatement financialStatement:financialStatementRepository.findAll())
        {
            profit = profit + financialStatement.earnings;
            profit = profit - financialStatement.expenses;
        }

        return  profit;
    }
}
