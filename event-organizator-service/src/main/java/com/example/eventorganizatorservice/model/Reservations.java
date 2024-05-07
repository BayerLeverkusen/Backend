package com.example.eventorganizatorservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
public class Reservations {

    @Id
    private int id;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private Type type;

    public Reservations(LocalDate startDate, LocalDate endDate, Type type) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;

    }


}
