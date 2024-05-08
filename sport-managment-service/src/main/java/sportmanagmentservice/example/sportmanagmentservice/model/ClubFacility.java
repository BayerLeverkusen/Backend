package sportmanagmentservice.example.sportmanagmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sportmanagmentservice.example.sportmanagmentservice.enums.FacilityType;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="club_facilities")
public class ClubFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int capacity;

    @Column
    @Enumerated(EnumType.STRING)
    private FacilityType type;

}
