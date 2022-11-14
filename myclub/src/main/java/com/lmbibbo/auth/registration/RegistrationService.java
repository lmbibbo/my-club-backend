package com.lmbibbo.auth.registration;

import com.lmbibbo.auth.ApplicationUser;
import com.lmbibbo.auth.impl.ApplicationUserServiceImpl;
import com.lmbibbo.security.PasswordConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final ApplicationUserServiceImpl applicationUserService;
    private final PasswordConfig passwordConfig;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException(String.format("Email: %s is invalid", request.getEmail()));
        }

        return applicationUserService.signUpUser(
                new ApplicationUser(
                        request.getName(),
                        request.getUsername(),
                        passwordConfig.passwordEncoder().encode(request.getPassword()),
                        request.getEmail()
                )
        );
    }

    public String confirmToken(String token) {
        return "";
    }
}
