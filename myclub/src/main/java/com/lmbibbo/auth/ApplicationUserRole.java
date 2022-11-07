package com.lmbibbo.auth;

import com.google.common.collect.Sets;
import com.lmbibbo.security.ApplicationUserPermission;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.lmbibbo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    PLAYER(Sets.newHashSet(PLAYER_READ,PLAYER_WRITE)),
    ADMIN(Sets.newHashSet(DATA_READ, DATA_WRITE, PLAYER_READ, PLAYER_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
