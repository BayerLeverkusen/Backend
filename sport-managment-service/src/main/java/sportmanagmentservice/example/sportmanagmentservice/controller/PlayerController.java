package sportmanagmentservice.example.sportmanagmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportmanagmentservice.example.sportmanagmentservice.dtos.PlayerDTO;
import sportmanagmentservice.example.sportmanagmentservice.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() { return ResponseEntity.ok(playerService.getAllPlayers()); }

}
