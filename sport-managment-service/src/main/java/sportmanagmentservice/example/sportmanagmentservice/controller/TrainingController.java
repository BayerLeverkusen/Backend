package sportmanagmentservice.example.sportmanagmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportmanagmentservice.example.sportmanagmentservice.dtos.TrainingRequest;
import sportmanagmentservice.example.sportmanagmentservice.model.Training;
import sportmanagmentservice.example.sportmanagmentservice.service.TrainingService;

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

}
