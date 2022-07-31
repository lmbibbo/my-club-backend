package com.lmbibbo.security;

public enum ApplicationUserPermission {
    PLAYER_READ("player:read"),
    PLAYER_WRITE("player:write"),
    DATA_READ("data:read"),
    DATA_WRITE("data:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
