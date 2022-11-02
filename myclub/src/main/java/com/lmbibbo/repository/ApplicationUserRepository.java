package com.lmbibbo.repository;

import com.lmbibbo.auth.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, Long> {
 //   Optional<ApplicationUser> findByEmail(String email);

    Optional<ApplicationUser> findByUsername(String username);
}
