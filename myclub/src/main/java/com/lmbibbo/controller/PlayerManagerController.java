package com.lmbibbo.controller;

import com.lmbibbo.model.Player;
import com.lmbibbo.service.PlayerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("management/api/v1/players")
public class PlayerManagerController {

    private final PlayerService playerService;

    public PlayerManagerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Collection<Player> getAllPlayers() {
        System.out.println("getAllPlayers");
        return playerService.list(10);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('data:write')")
    public void registerNewPlayer(@RequestBody Player player) {
        System.out.println("registerNewPlayer");
        playerService.create(player);
    }

    @DeleteMapping(path = "{playerId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePlayer(@PathVariable("playerId") Long playerId) {
        System.out.println("deletePlayer");
        playerService.delete(playerId);
    }

    @PutMapping(path = "{playerId}")
    @PreAuthorize("hasAuthority('player:write')")
    public void updatePlayer(@RequestBody Player player) {
        System.out.println("updatePlayer");
        playerService.update(player);

    }

}
