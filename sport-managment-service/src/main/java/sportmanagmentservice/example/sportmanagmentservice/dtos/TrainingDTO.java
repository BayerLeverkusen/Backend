package sportmanagmentservice.example.sportmanagmentservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    private int id;
    private LocalTime time;
    private LocalDate date;
    private int clubFacilityId;
    private List<Integer> playerIds;
}
