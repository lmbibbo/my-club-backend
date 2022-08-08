package com.lmbibbo.service;

public class IntegerSecuenceGenerator {

    private static Integer lastId = 0;

    public static Integer generateId() {
        return ++lastId;
    }
    
    public static void setBaseId(Integer newId) {
        lastId=newId;
    }
}
