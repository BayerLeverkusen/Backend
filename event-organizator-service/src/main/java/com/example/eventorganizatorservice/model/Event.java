package com.example.eventorganizatorservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    public String name;

    @Column
    public LocalDate eventDate;

    @Column
    public boolean type;

    public Event(String name, Boolean type, LocalDate eventDate) {
        this.name = name;
        this.eventDate = eventDate;
        this.type = type;
    }



}
