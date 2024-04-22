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
@Table(name = "eventTemplates")
public class EventTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;




}
