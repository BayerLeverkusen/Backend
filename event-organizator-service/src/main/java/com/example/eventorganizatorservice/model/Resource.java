package com.example.eventorganizatorservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    // Common properties/methods for all resources
}
