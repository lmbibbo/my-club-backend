package com.lmbibbo.auth;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ApplicationUserService {

    ApplicationUser saveApplicationUser(ApplicationUser applicationUser);
    Optional<ApplicationUser> getApplicationUser(String username);
    List<ApplicationUser> getApplicationsUsers(int limit);
/*
    private final ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserService(ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao
                .selectApplicationUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
    }*/
}
