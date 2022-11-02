package com.lmbibbo.service.implementation;

import com.lmbibbo.auth.ApplicationUser;
import com.lmbibbo.repository.ApplicationUserRepository;
import com.lmbibbo.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ApplicationUserServiceImpl implements ApplicationUserService, UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

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

}
