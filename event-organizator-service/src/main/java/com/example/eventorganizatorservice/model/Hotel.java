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
    public String name;

    @Column
    public String country;

    @Column
    public String city;

    @Column
    public String address;

    @Column
    public double price;

    public Hotel(String name, String country, String city, String address, double price) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.price = price;
    }

}
