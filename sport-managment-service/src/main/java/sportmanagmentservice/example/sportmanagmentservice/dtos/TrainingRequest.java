package sportmanagmentservice.example.sportmanagmentservice.dtos;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
public class TrainingRequest {
    private LocalDate date;
    private LocalTime time;
    private int clubFacilityId;
    private Set<Integer> playerIds;
}

