package com.lmbibbo.model;

public class IdentityCard {
    public IdentityCard(IdentityCardType type, String number) {
        this.type = type;
        this.number = number;
    }
    private IdentityCardType type;
    private String number;
    public IdentityCardType getType() {
        return type;
    }
    public void setType(IdentityCardType type) {
        this.type = type;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

}
