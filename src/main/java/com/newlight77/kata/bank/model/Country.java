package com.newlight77.kata.bank.model;

public enum Country {
    FRANCE("FRANCE"),
    ITALY("ITALY"),
    PORTUGAL("PORTUGAL"),
    INDIA("INDIA"),
    UNKOWN("UNKOWN");

    private String name;

    Country(String name) {
        this.name = name;
    }
}
