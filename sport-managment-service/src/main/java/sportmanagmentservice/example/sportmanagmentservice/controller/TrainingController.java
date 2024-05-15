package sportmanagmentservice.example.sportmanagmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sportmanagmentservice.example.sportmanagmentservice.dtos.PlayerDTO;
import sportmanagmentservice.example.sportmanagmentservice.dtos.TrainingDTO;
import sportmanagmentservice.example.sportmanagmentservice.dtos.TrainingRequest;
import sportmanagmentservice.example.sportmanagmentservice.model.Training;
import sportmanagmentservice.example.sportmanagmentservice.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping("/api/training")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @PostMapping("/create")
    public ResponseEntity<Training> createTraining(@RequestBody TrainingRequest request) {
        Training training = trainingService.createTraining(request);
        return new ResponseEntity<>(training, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TrainingDTO>> getAllTrainings() { return ResponseEntity.ok(trainingService.getAllTrainings()); }

    @GetMapping("/getByClubFacilityId/{clubFacilityId}")
    public ResponseEntity<List<TrainingDTO>> getTrainingsByClubFacilityId(@PathVariable Long clubFacilityId) {
        List<TrainingDTO> trainings = trainingService.getTrainingsByClubFacilityId(clubFacilityId);
        return ResponseEntity.ok(trainings);
    }

}
