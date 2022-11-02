package com.lmbibbo.repository;

import com.lmbibbo.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, Long> {

}
