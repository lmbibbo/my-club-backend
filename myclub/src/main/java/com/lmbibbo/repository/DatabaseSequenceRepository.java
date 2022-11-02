package com.lmbibbo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, Long> {

}
