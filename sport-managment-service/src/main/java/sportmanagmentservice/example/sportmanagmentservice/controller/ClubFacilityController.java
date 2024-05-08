package sportmanagmentservice.example.sportmanagmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sportmanagmentservice.example.sportmanagmentservice.dtos.ClubFacilityDTO;
import sportmanagmentservice.example.sportmanagmentservice.enums.FacilityType;
import sportmanagmentservice.example.sportmanagmentservice.service.ClubFacilityService;

import java.util.List;

@RestController
@RequestMapping("/api/clubFacility")
public class ClubFacilityController {

    @Autowired
    private ClubFacilityService clubFacilityService;

    @GetMapping("/getAll")
    public List<ClubFacilityDTO> getAllClubFacilities() {
        return clubFacilityService.getAllClubFacilities();
    }

    @GetMapping("/getByType")
    public List<ClubFacilityDTO> getClubFacilitiesByType(@RequestParam FacilityType type) {
        return clubFacilityService.getClubFacilitiesByType(type);
    }
}
