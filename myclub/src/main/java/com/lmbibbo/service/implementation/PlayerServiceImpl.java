package com.lmbibbo.service.implementation;

import com.lmbibbo.model.Player;
import com.lmbibbo.repository.PlayerRepository;
import com.lmbibbo.service.SecuenceGenerator;
import com.lmbibbo.service.PlayerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import static java.lang.Boolean.TRUE;
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private static final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class);

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player create(Player player) {
        log.info("Creating Player {}", player.getName());
        player.setPlayerId(SecuenceGenerator.generateId());
        player.setCreated(LocalDateTime.now());
        return playerRepository.save(player);
    }

    @Override
    public Collection<Player> list(int limit) {
        log.info("Fetching all Players");
        return playerRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Optional<Player> get(Long id) {
        log.info("Fetching Player Id {}", id);
        return playerRepository.findById(id);
    }

    @Override
    public Player update(Player player) {
        log.info("Updating Player {}", player.getName());
        return playerRepository.save(player);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Player Id {}", id);
        playerRepository.deleteById(id);
        return TRUE;
    }
}
