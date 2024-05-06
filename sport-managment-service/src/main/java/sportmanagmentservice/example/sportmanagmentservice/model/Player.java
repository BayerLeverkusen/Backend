package sportmanagmentservice.example.sportmanagmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sportmanagmentservice.example.sportmanagmentservice.enums.PlayerPosition;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private LocalDate dateOfBirth;

    @Column
    private String nationality;

    @Column
    private double averageRating;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "player_positions")
    private Set<PlayerPosition> positions = new HashSet<>();

    @Column
    private int goals;

    @Column
    private int assists;

    @Column
    private int cleanSheets;

    @Column
    private boolean isInjured;

    @ManyToMany(mappedBy = "players")
    private Set<Training> trainings;
}

