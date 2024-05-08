package com.example.directorservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BudgetProposal")
public class BudgetProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column
    public int marketingAmmount;

    @Column
    public int eventOrgAmmount;

    @Column
    public int sportingAmmount;

    @Column
    public LocalDate date;

    @Column
    public int numOfVotes;

    @Column
    public boolean approved;

    @Column
    public int quarter;

    public BudgetProposal(int marketingAmmount, int eventOrgAmmount, int sportingAmmount) {
        this.marketingAmmount = marketingAmmount;
        this.eventOrgAmmount = eventOrgAmmount;
        this.sportingAmmount = sportingAmmount;
        this.date = LocalDate.now();
        this.numOfVotes = 0;
        this.approved = false;

        int month = date.getMonthValue();

        if(month>=1 && month<=3)
        {
            quarter=1;
        }
        else if(month >= 4 && month <=6)
        {
            quarter=2;
        }
        else if(month >= 7 && month <=9)
        {
            quarter=3;
        }
        else
        {
            quarter=4;
        }

    }

    public int getMarketingAmmount() {
        return marketingAmmount;
    }

    public void setMarketingAmmount(int marketingAmmount) {
        this.marketingAmmount = marketingAmmount;
    }

    public int getEventOrgAmmount() {
        return eventOrgAmmount;
    }

    public void setEventOrgAmmount(int eventOrgAmmount) {
        this.eventOrgAmmount = eventOrgAmmount;
    }

    public int getSportingAmmount() {
        return sportingAmmount;
    }

    public void setSportingAmmount(int sportingAmmount) {
        this.sportingAmmount = sportingAmmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }
}
