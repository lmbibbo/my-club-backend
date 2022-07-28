package com.lmbibbo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmbibbo.Service.PlayerService;
import com.lmbibbo.model.Player;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    List<Player> fechAllPlayers() {
        return playerService.getAllPlayers();
    }
    
    
}
