package com.lmbibbo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmbibbo.model.Player;
import com.lmbibbo.service.PlayerService;

@RestController
@RequestMapping("api/v1/players")
@CrossOrigin("*")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Player> getAllPlayers() {
        System.out.println("getAllPlayers");
        return playerService.getAllPlayers();
    }
    
    
}
