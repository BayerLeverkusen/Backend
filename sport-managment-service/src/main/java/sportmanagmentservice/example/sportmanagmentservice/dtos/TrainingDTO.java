package sportmanagmentservice.example.sportmanagmentservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    private int id;
    private LocalTime time;
    private int clubFacilityId;
}
