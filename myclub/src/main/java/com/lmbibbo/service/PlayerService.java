package com.lmbibbo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lmbibbo.model.Player;
import com.lmbibbo.repository.PlayerRepository;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        Integer maxId=0;
        for (Player p : this.getAllPlayers()) {
            if (maxId< p.getPlayerId()) maxId=p.getPlayerId();    
        }
        IntegerSecuenceGenerator.setBaseId(maxId);
    }
    
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void registerNewPlayer(Player player) {
        player.setPlayerId(IntegerSecuenceGenerator.generateId());
        player.setCreated(LocalDateTime.now());
        playerRepository.insert(player);
    }

    public void deletePlayer(Integer playerId) {
        Optional<Player> elPlayer=playerRepository.findById(playerId);
        if (elPlayer.isPresent()) playerRepository.delete(elPlayer.get());
    }

    public void updatePlayer(Integer playerId, Player player) {
        Optional<Player> elPlayer=playerRepository.findById(playerId);
        if (elPlayer.isPresent()) {
            elPlayer.get().setAddress(player.getAddress());
            elPlayer.get().setDni(player.getDni());
            elPlayer.get().setEmail(player.getEmail());
            elPlayer.get().setMemberNumber(player.getMemberNumber());
            elPlayer.get().setName(player.getName());
            playerRepository.save(elPlayer.get());
        } 
    }
}