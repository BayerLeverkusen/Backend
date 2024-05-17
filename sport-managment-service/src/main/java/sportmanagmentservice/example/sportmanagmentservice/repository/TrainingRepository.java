package sportmanagmentservice.example.sportmanagmentservice.repository;

import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sportmanagmentservice.example.sportmanagmentservice.model.Training;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

    Training save(Training training);

    List<Training> findByClubFacilityId(Long clubFacilityId);

    List<Training> findByDate(LocalDate date);
}
