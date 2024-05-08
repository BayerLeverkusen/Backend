package sportmanagmentservice.example.sportmanagmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sportmanagmentservice.example.sportmanagmentservice.enums.FacilityType;
import sportmanagmentservice.example.sportmanagmentservice.model.ClubFacility;

import java.util.List;

@Repository
public interface ClubFacilityRepository extends JpaRepository<ClubFacility, Integer> {

    ClubFacility save(ClubFacility clubFacility);

    boolean existsByname(String name);

    List<ClubFacility> findAllByType(FacilityType type);
}
