package com.example.eventorganizatorservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fields")
public class PlayingField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private boolean type;

    @Column
    private double rating;

    public PlayingField(String name, String country, String city, String address, boolean type,double rating) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.type = type;
        this.rating = rating;
    }

}
