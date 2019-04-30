package com.newlight77.kata.bank.model;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private UUID id;
    private Client client;
    private double balance;
}
