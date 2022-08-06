package com.lmbibbo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.lmbibbo.model.Player;
import com.lmbibbo.repository.PlayerRepository;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void registerNewPlayer(Player player) {
        player.setPlayerId(UUID.randomUUID());
        player.setCreated(LocalDateTime.now());
        playerRepository.insert(player);
    }

    public void deletePlayer(UUID playerId) {
        Optional<Player> elPlayer=playerRepository.findById(playerId);
        if (elPlayer.isPresent()) playerRepository.delete(elPlayer.get());
    }

    public void updatePlayer(UUID playerId, Player player) {
    }
}