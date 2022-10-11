package com.lmbibbo.model;

public enum IdentityCardType {
    DNI("DNI"),
    LC("LC"),
    LE("LE");

    private final String identityCardType;

    IdentityCardType(String identityCardType) {
        this.identityCardType = identityCardType;
    }

    public String getIdentityCardType() {
        return identityCardType;
    }
}
