package sportmanagmentservice.example.sportmanagmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sportmanagmentservice.example.sportmanagmentservice.model.Player;
import sportmanagmentservice.example.sportmanagmentservice.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

    Training save(Training training);
}
