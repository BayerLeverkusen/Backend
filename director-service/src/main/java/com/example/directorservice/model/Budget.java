package com.example.directorservice.model;

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
@Table(name = "Budget")
public class Budget
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    @Column
    public int proposalId;
}
