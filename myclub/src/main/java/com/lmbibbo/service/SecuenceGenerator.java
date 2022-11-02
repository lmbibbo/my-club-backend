package com.lmbibbo.service;

public class SecuenceGenerator {

    private static Long lastId = Long.valueOf(1);

    public static Long generateId() {
        return ++lastId;
    }

    public static void setBaseId(Long newId) {
        lastId=newId;
    }
}
