package sportmanagmentservice.example.sportmanagmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportmanagmentservice.example.sportmanagmentservice.dtos.PlayerDTO;
import sportmanagmentservice.example.sportmanagmentservice.model.Player;
import sportmanagmentservice.example.sportmanagmentservice.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private PlayerDTO convertToDto(Player player){
        return PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .lastName(player.getLastName())
                .nationality(player.getNationality())
                .positions(player.getPositions().stream()
                        .map(Enum::toString)
                        .collect(Collectors.toSet()))
                .isInjured(player.isInjured())
                .build();
    }

}
