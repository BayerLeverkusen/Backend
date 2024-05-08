package com.example.eventorganizatorservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "hotels")
public class Hotel extends Resource {



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




}
