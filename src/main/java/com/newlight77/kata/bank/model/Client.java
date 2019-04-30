package com.newlight77.kata.bank.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private String firstName;
    private String lastName;
    private double wallet;
    private Country country;
}
