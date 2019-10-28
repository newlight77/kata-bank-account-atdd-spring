package com.newlight77.kata.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private Account account;
    private Card card;
    private Atm atm;
    private double amount;
    private String type;
    private String status;
}
