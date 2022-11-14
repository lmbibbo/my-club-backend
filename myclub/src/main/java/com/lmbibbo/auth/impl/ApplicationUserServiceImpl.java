package com.lmbibbo.auth.impl;

import com.lmbibbo.auth.ApplicationUser;
import com.lmbibbo.auth.ApplicationUserRepository;
import com.lmbibbo.auth.ApplicationUserService;
import com.lmbibbo.repository.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
@Transactional
@Slf4j
public class ApplicationUserServiceImpl implements ApplicationUserService, UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = this.getApplicationUser(username)
                .orElseThrow(() -> {
                    log.error("User {} Not found", username);
                    return new UsernameNotFoundException("User " + username + " Not found");
                });
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(),
                applicationUser.getPassword(), applicationUser.getAuthorities());
    }

    @Override
    public ApplicationUser saveApplicationUser(ApplicationUser applicationUser) {
        log.info("Saving a new user {} to the Database", applicationUser.getUsername());
        applicationUser.setId(sequenceGeneratorService.generateSequence(ApplicationUser.SEQUENCE_NAME));
        return applicationUserRepository.save(applicationUser);
    }

    @Override
    public Optional<ApplicationUser> getApplicationUser(String username) {
        log.info("Fetching a user: {} ", username);
        return applicationUserRepository.findByUsername(username);
    }

    @Override
    public List<ApplicationUser> getApplicationsUsers(int limit) {
        log.info("Fetching all users ");
        return applicationUserRepository.findAll();
    }

    public String signUpUser(ApplicationUser applicationUser) {

        if (applicationUserRepository.findByUsername(applicationUser.getUsername()).isPresent()){
            throw new IllegalStateException(
                    String.format("UserName: %s already exists",applicationUser.getUsername()));
        };

        if (applicationUserRepository.findByEmail(applicationUser.getEmail()).isPresent()){

            throw new IllegalStateException(
                    String.format("Email: %s already exists",applicationUser.getEmail()));
        };

        log.info("Saving-Up a new user {} to the Database", applicationUser.
                getUsername());

        applicationUser.setId(sequenceGeneratorService.generateSequence(ApplicationUser.SEQUENCE_NAME));
        applicationUserRepository.save(applicationUser);

        // Todo: Send confirmation Token

        return "it works";
    }
}
