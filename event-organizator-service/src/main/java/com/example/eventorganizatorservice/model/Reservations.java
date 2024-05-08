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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource; // Reference to hotel, transport, or playing field

    @Column
    private Type type;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;



    public Reservations(LocalDate startDate, LocalDate endDate, Type type, Resource resource) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.resource = resource;

    }


}
