package sportmanagmentservice.example.sportmanagmentservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private int id;
    private String name;
    private String lastName;
    private String nationality;
    private Set<String> positions;
}
