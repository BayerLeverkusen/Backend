package com.example.directorservice.service;

import com.example.directorservice.model.Loan;
import com.example.directorservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.spi.LocaleNameProvider;

@Service
public class LoanService
{
    @Autowired
    private LoanRepository loanRepository;

    public boolean checkCreditStatus()
    {
        for (Loan loan:loanRepository.findAll())
        {
            if(loan.paidStatus==false)
            {
                return false;
            }

        }

        return true;
    }

    public String takeLoan(int ammount)
    {
        if(checkCreditStatus()==false)
        {
            return "The club has unpaid loans, you can't get another loan until it gets repaid.";
        }
        else
        {
            Loan loan = new Loan(ammount, LocalDate.now().plusMonths(6));
            loanRepository.save(loan);
            return "Loan succesfully taken.";
        }
    }

    public int getActiveLoanAmmount()
    {
        for (Loan loan:loanRepository.findAll())
        {
            if(loan.paidStatus==false)
                return loan.ammount;
        }

        return 0;
    }

    public void payLoan()
    {
        for (Loan loan:loanRepository.findAll())
        {
            if(loan.paidStatus==false)
            {
                loan.paidStatus = true;
                loanRepository.save(loan);
            }
        }
    }
}
