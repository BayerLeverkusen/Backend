package com.example.eventorganizatorservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    // Common properties/methods for all resources
}
