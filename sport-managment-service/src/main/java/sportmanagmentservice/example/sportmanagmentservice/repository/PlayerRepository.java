package sportmanagmentservice.example.sportmanagmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sportmanagmentservice.example.sportmanagmentservice.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Player save(Player player);

    boolean existsBylastName(String lastName);

}
