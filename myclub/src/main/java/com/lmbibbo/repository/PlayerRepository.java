package com.lmbibbo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lmbibbo.model.Player;

public interface PlayerRepository extends MongoRepository<Player, Integer> {
    Optional<Player> findStudentByEmail(String email);

    
}
