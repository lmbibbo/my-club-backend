package com.lmbibbo.service.implementation;

import com.lmbibbo.model.Player;
import com.lmbibbo.repository.PlayerRepository;
import com.lmbibbo.service.PlayerService;
import com.lmbibbo.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import static java.lang.Boolean.TRUE;
@Service
@Transactional
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private static final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Override
    public Player create(Player player) {
        log.info("Creating Player {}", player.getName());
        player.setPlayerId(sequenceGeneratorService.generateSequence(Player.SEQUENCE_NAME));
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
