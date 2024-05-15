package sportmanagmentservice.example.sportmanagmentservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportmanagmentservice.example.sportmanagmentservice.dtos.PlayerDTO;
import sportmanagmentservice.example.sportmanagmentservice.dtos.TrainingDTO;
import sportmanagmentservice.example.sportmanagmentservice.dtos.TrainingRequest;
import sportmanagmentservice.example.sportmanagmentservice.model.ClubFacility;
import sportmanagmentservice.example.sportmanagmentservice.model.Player;
import sportmanagmentservice.example.sportmanagmentservice.model.Training;
import sportmanagmentservice.example.sportmanagmentservice.repository.ClubFacilityRepository;
import sportmanagmentservice.example.sportmanagmentservice.repository.PlayerRepository;
import sportmanagmentservice.example.sportmanagmentservice.repository.TrainingRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private ClubFacilityRepository clubFacilityRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public Training createTraining(TrainingRequest request) {
        ClubFacility clubFacility = clubFacilityRepository.findById(request.getClubFacilityId())
                .orElseThrow(() -> new EntityNotFoundException("Club facility with id not found: " + request.getClubFacilityId()));

        List<Player> playerList = playerRepository.findAllById(request.getPlayerIds());
        Set<Player> players = new HashSet<>(playerList);

        Training training = Training.builder()
                .date(request.getDate())
                .time(request.getTime())
                .clubFacility(clubFacility)
                .players(players)
                .build();

        return trainingRepository.save(training);
    }

    public List<TrainingDTO> getAllTrainings() {
        List<Training> trainings = trainingRepository.findAll();
        return trainings.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<TrainingDTO> getTrainingsByClubFacilityId(Long clubFacilityId) {
        List<Training> trainings = trainingRepository.findByClubFacilityId(clubFacilityId);
        return trainings.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private TrainingDTO convertToDto(Training training){
        return TrainingDTO.builder()
                .id(training.getId())
                .time(training.getTime())
                .clubFacilityId(training.getClubFacility().getId())
                .build();
    }
}
