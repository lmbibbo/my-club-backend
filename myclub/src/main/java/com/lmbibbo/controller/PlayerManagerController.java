package com.lmbibbo.controller;

import java.util.List;

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
        System.out.println(player);
    }

    @DeleteMapping(path = "{playerId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePlayer(@PathVariable("playerId") Integer playerId) {
        System.out.println("deletePlayer");
        System.out.println(playerId);
    }

    @PutMapping(path = "{playerId}")
    @PreAuthorize("hasAuthority('player:write')")
    public void updatePlayer(@PathVariable("playerId") Integer playerId, @RequestBody Player player) {
        System.out.println("updatePlayer");
        System.out.println(String.format("%s %s", playerId, player));
    }

    
}
