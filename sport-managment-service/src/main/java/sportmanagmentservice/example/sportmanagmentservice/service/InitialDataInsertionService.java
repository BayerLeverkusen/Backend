package sportmanagmentservice.example.sportmanagmentservice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportmanagmentservice.example.sportmanagmentservice.enums.FacilityType;
import sportmanagmentservice.example.sportmanagmentservice.enums.PlayerPosition;
import sportmanagmentservice.example.sportmanagmentservice.model.ClubFacility;
import sportmanagmentservice.example.sportmanagmentservice.model.Player;
import sportmanagmentservice.example.sportmanagmentservice.repository.ClubFacilityRepository;
import sportmanagmentservice.example.sportmanagmentservice.repository.PlayerRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class InitialDataInsertionService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubFacilityRepository clubFacilityRepository;

    private void insertPlayerIfNotExists(String firstName, String lastName, LocalDate dateOfBirth, String nationality, double averageRating, Set<PlayerPosition> positions, int goals, int assists, int cleanSheets, boolean isInjured){
        if(!playerRepository.existsBylastName(lastName)){
            Player player = Player.builder()
                    .name(firstName)
                    .lastName(lastName)
                    .dateOfBirth(dateOfBirth)
                    .nationality(nationality)
                    .averageRating(averageRating)
                    .positions(positions != null ? positions : new HashSet<>())
                    .goals(goals)
                    .assists(assists)
                    .cleanSheets(cleanSheets)
                    .isInjured(isInjured)
                    .build();
            playerRepository.save(player);
        }
    }

    private void insertClubFacilityIfNotExists(String name, int capacity, FacilityType type){
        if(!clubFacilityRepository.existsByname(name)){
            ClubFacility clubFacility = ClubFacility.builder()
                    .name(name)
                    .capacity(capacity)
                    .type(type)
                    .build();

            clubFacilityRepository.save(clubFacility);
        }
    }

    @Transactional
    public void insertInitialData() {
        // INSERTING THE PLAYERS
        Set<PlayerPosition> playerPositions1 = new HashSet<>();
        playerPositions1.add(PlayerPosition.GK);
        insertPlayerIfNotExists("Lukas", "Hradecky", LocalDate.of(1989, 11, 24), "Finland", 7, playerPositions1, 0, 0, 14, false );
        Set<PlayerPosition> playerPositions2 = new HashSet<>();
        playerPositions2.add(PlayerPosition.GK);
        insertPlayerIfNotExists("Matej", "Kovar", LocalDate.of(2000,5,17), "Czech Republic", 7.3, playerPositions2, 0,0,0,false);
        Set<PlayerPosition> playerPositions3 = new HashSet<>();
        playerPositions3.add(PlayerPosition.RB);
        playerPositions3.add(PlayerPosition.RWB);
        insertPlayerIfNotExists("Jeremie", "Frimpong", LocalDate.of(2000,12,10), "Netherlands", 7.4, playerPositions3, 9,7,14, false);
        Set<PlayerPosition> playerPosition4 = new HashSet<>();
        playerPosition4.add(PlayerPosition.LB);
        playerPosition4.add(PlayerPosition.LWB);
        insertPlayerIfNotExists("Alejandro", "Grimaldo", LocalDate.of(1995,9,20), "Spain", 7.9, playerPosition4, 9,13,13, false);
        Set<PlayerPosition> playerPosition5 = new HashSet<>();
        playerPosition5.add(PlayerPosition.CB);
        insertPlayerIfNotExists("Piero", "Hincapie", LocalDate.of(2002,1,9), "Ecuador", 7.2, playerPosition5, 1,2,8, false);
        Set<PlayerPosition> playerPosition6 = new HashSet<>();
        playerPosition6.add(PlayerPosition.CB);
        insertPlayerIfNotExists("Odilon", "Kossounou", LocalDate.of(2001,1,4), "Ivory Coast", 7.1, playerPosition6, 1,0,9, false);
        Set<PlayerPosition> playerPosition7 = new HashSet<>();
        playerPosition7.add(PlayerPosition.CB);
        playerPosition7.add(PlayerPosition.LB);
        insertPlayerIfNotExists("Josip", "Stanisic", LocalDate.of(2000,4,2), "Croatia", 7.2, playerPosition7, 2,0,5, false);
        Set<PlayerPosition> playerPosition8 = new HashSet<>();
        playerPosition8.add(PlayerPosition.CB);
        insertPlayerIfNotExists("Jonathan", "Tah", LocalDate.of(1996,2,11), "Germany", 7.1, playerPosition8, 4,1,14, false);
        Set<PlayerPosition> playerPosition9 = new HashSet<>();
        playerPosition9.add(PlayerPosition.CB);
        insertPlayerIfNotExists("Edmond", "Tapsoba", LocalDate.of(1999,2,2), "Burkina Faso", 7, playerPosition9, 0,1,12, false);
        Set<PlayerPosition> playerPosition10 = new HashSet<>();
        playerPosition10.add(PlayerPosition.LM);
        playerPosition10.add(PlayerPosition.AM);
        playerPosition10.add(PlayerPosition.LW);
        insertPlayerIfNotExists("Amine", "Adli", LocalDate.of(2000,5,10), "Morocco", 7, playerPosition10, 3,3,9, false);
        Set<PlayerPosition> playerPosition11 = new HashSet<>();
        playerPosition11.add(PlayerPosition.CDM);
        playerPosition11.add(PlayerPosition.CM);
        insertPlayerIfNotExists("Robert", "Andrich", LocalDate.of(1994,9,22), "Germany", 7, playerPosition11, 3,2,9, false);
        Set<PlayerPosition> playerPosition12 = new HashSet<>();
        playerPosition12.add(PlayerPosition.CDM);
        playerPosition12.add(PlayerPosition.CM);
        insertPlayerIfNotExists("Exequiel", "Palacios", LocalDate.of(1998,10,5), "Argentina", 7.6, playerPosition12, 4,5,9, false);
        Set<PlayerPosition> playerPosition13 = new HashSet<>();
        playerPosition13.add(PlayerPosition.RW);
        playerPosition13.add(PlayerPosition.RM);
        insertPlayerIfNotExists("Nathan", "Tella", LocalDate.of(1999,7,5), "Nigeria", 7.1, playerPosition13, 5,2,9, false);
        Set<PlayerPosition> playerPosition14 = new HashSet<>();
        playerPosition14.add(PlayerPosition.AM);
        playerPosition14.add(PlayerPosition.CF);
        insertPlayerIfNotExists("Florian", "Wirtz", LocalDate.of(2003,5,3), "Germany", 7.7, playerPosition14, 11,11,9, false);
        Set<PlayerPosition> playerPosition15 = new HashSet<>();
        playerPosition15.add(PlayerPosition.CDM);
        playerPosition15.add(PlayerPosition.CM);
        insertPlayerIfNotExists("Granit", "Xhaka", LocalDate.of(1992,9,27), "Switzerland", 7.3, playerPosition15, 7,3,9, false);
        Set<PlayerPosition> playerPosition16 = new HashSet<>();
        playerPosition16.add(PlayerPosition.ST);
        insertPlayerIfNotExists("Victor", "Boniface", LocalDate.of(2000,12,23), "Nigeria", 7.5, playerPosition16, 12,8,9, false);
        Set<PlayerPosition> playerPosition17 = new HashSet<>();
        playerPosition17.add(PlayerPosition.ST);
        insertPlayerIfNotExists("Adam", "Hlozek", LocalDate.of(2002,7,25), "Czech Republic", 7, playerPosition17, 2,3,9, false);
        Set<PlayerPosition> playerPosition18 = new HashSet<>();
        playerPosition18.add(PlayerPosition.AM);
        playerPosition18.add(PlayerPosition.RM);
        insertPlayerIfNotExists("Jonas", "Hofmann", LocalDate.of(1992,7,14), "Germany", 7.4, playerPosition18, 5,6,9, false);
        Set<PlayerPosition> playerPosition19 = new HashSet<>();
        playerPosition19.add(PlayerPosition.ST);
        insertPlayerIfNotExists("Borja", "Iglesias", LocalDate.of(1993,1,17), "Spain", 6.4, playerPosition19, 0,0,9, true);
        Set<PlayerPosition> playerPosition20 = new HashSet<>();
        playerPosition20.add(PlayerPosition.ST);
        insertPlayerIfNotExists("Patrik", "Schick", LocalDate.of(1996,1,24), "Czech Republic", 6.9, playerPosition20, 6,0,9, false);
        Set<PlayerPosition> playerPosition21 = new HashSet<>();
        playerPosition21.add(PlayerPosition.ST);
        insertPlayerIfNotExists("Ifeel", "Design", LocalDate.of(2001,7,19), "Serbia", 5.5, playerPosition21, 7, 7, 8, true);

        //INSERTING CLUB FACILITIES
        insertClubFacilityIfNotExists("Training Pitch 1", 20, FacilityType.TRAINING_PITCH);
        insertClubFacilityIfNotExists("Training Pitch 2", 10, FacilityType.TRAINING_PITCH);
        insertClubFacilityIfNotExists("Gym Room 1", 10, FacilityType.GYM);
        insertClubFacilityIfNotExists("Gym Room 2", 10, FacilityType.GYM);
        insertClubFacilityIfNotExists("Meeting Room", 20, FacilityType.MEETING_ROOM);
        insertClubFacilityIfNotExists("Hospital", 5, FacilityType.HOSPITAL);

    }
}
