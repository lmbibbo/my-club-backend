package com.lmbibbo.auth;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByEmail(String email);

    Optional<ApplicationUser> findByUsername(String username);

    Optional<ApplicationUser> findByConfirmationToken_Token(String token);


}
