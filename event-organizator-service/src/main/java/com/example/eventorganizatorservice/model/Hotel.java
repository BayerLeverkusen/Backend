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
@Table(name = "hotels")
public class Hotel {

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
    private double price;

    @Column
    private double rating;

    public Hotel(String name, String country, String city, String address, double price, double rating) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.price = price;
        this.rating = rating;
    }

}
