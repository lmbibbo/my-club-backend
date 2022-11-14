package com.lmbibbo.auth;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ApplicationUserService {

    ApplicationUser saveApplicationUser(ApplicationUser applicationUser);

    ApplicationUser createApplicationUser(ApplicationUser applicationUser);

    Optional<ApplicationUser> getApplicationUser(String username);
    List<ApplicationUser> getApplicationsUsers(int limit);

}
