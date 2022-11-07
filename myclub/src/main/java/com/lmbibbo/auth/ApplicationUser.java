package com.lmbibbo.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
public class ApplicationUser implements UserDetails {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long id;
    private String name;
    @Indexed(unique = true)
    @NotEmpty(message = "Username cannot be empty o null")
    private String username;
    private String password;
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private boolean isAccountNonExpired = false;
    private boolean isAccountNonLocked = false;
    private boolean isCredentialsNonExpired = false;
    private boolean isEnabled = false;
    @Indexed(unique = true)
    @NotEmpty(message = "Email cannot be empty o null")
    private String email;

    public ApplicationUser(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getGrantedAuthorities();
    }

}
