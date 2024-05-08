package sportmanagmentservice.example.sportmanagmentservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubFacilityDTO {
    private int id;
    private String name;
    private int capacity;
    private String type;
}
