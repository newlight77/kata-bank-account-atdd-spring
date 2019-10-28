package com.newlight77.kata.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Account account;
    private Atm atm;
    private double amount;
    private Date date;
    private String status;
}
