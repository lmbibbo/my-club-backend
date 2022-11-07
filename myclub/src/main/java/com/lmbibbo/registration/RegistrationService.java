package com.lmbibbo.registration;

import com.lmbibbo.auth.ApplicationUser;
import com.lmbibbo.security.PasswordConfig;
import com.lmbibbo.service.implementation.ApplicationUserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final ApplicationUserServiceImpl applicationUserService;
    private final PasswordConfig passwordConfig;
    public String register(RegistrationRequest request) {
        String email = request.getEmail();
        Boolean isValidEmail = emailValidator.test(email);
        if (!isValidEmail) {
            throw new RuntimeException(String.format("email: %s not Valid", email));
        }
        return applicationUserService.signUpUser(
                new ApplicationUser(
                        request.getName(),
                        request.getUsername(),
                        passwordConfig.passwordEncoder().encode(request.getPassword()),
                        email
                )
        );
    }
}
