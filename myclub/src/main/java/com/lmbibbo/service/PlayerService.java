package com.lmbibbo.service;


import com.lmbibbo.model.Player;

import java.util.Collection;
import java.util.Optional;


public interface PlayerService {
    Player create(Player player);
    Collection<Player> list(int limit);
    Optional<Player> get(Long id);
    Player update(Player player);
    Boolean delete(Long id);
}