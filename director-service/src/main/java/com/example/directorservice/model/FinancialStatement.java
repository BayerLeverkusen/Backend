package com.example.directorservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FinancialStatement")
public class FinancialStatement
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column
    public Date datePublished;

    @Column
    public int expenses;

    @Column
    public int earnings;

    public FinancialStatement(Date date, int expenses, int earnings) {
        this.datePublished = date;
        this.expenses = expenses;
        this.earnings = earnings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return datePublished;
    }

    public void setDate(Date date) {
        this.datePublished = date;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
}
