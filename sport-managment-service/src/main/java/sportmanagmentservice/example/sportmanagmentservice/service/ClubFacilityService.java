package sportmanagmentservice.example.sportmanagmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportmanagmentservice.example.sportmanagmentservice.dtos.ClubFacilityDTO;
import sportmanagmentservice.example.sportmanagmentservice.dtos.PlayerDTO;
import sportmanagmentservice.example.sportmanagmentservice.enums.FacilityType;
import sportmanagmentservice.example.sportmanagmentservice.model.ClubFacility;
import sportmanagmentservice.example.sportmanagmentservice.model.Player;
import sportmanagmentservice.example.sportmanagmentservice.repository.ClubFacilityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubFacilityService {
    @Autowired
    private ClubFacilityRepository clubFacilityRepository;

    public List<ClubFacilityDTO> getAllClubFacilities(){
        List<ClubFacility> clubFacilities = clubFacilityRepository.findAll();
        return clubFacilities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<ClubFacilityDTO> getClubFacilitiesByType(FacilityType type) {
        List<ClubFacility> clubFacilities = clubFacilityRepository.findAllByType(type);
        return clubFacilities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private ClubFacilityDTO convertToDto(ClubFacility clubFacility){
        return ClubFacilityDTO.builder()
                .id(clubFacility.getId())
                .name(clubFacility.getName())
                .capacity(clubFacility.getCapacity())
                .type(clubFacility.getType().name())
                .build();
    }
}
