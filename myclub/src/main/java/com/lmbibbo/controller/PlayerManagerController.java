package com.lmbibbo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmbibbo.model.Player;
import com.lmbibbo.service.PlayerService;

@RestController
@RequestMapping("management/api/v1/players")
public class PlayerManagerController {

    private final PlayerService playerService;

    public PlayerManagerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Player> getAllPlayers() {
        System.out.println("getAllPlayers");
        return playerService.getAllPlayers();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('data:write')")
    public void registerNewPlayer(@RequestBody Player player) {
        System.out.println("registerNewPlayer");
        playerService.registerNewPlayer(player);
    }

    @DeleteMapping(path = "{playerId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePlayer(@PathVariable("playerId") UUID playerId) {
        System.out.println("deletePlayer");
        playerService.deletePlayer(playerId);
    }

    @PutMapping(path = "{playerId}")
    @PreAuthorize("hasAuthority('player:write')")
    public void updatePlayer(@PathVariable("playerId") UUID playerId, @RequestBody Player player) {
        System.out.println("updatePlayer");
        playerService.updatePlayer(playerId, player);    

    }

    
}
