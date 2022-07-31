package com.lmbibbo.service;

import java.util.List;

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
}