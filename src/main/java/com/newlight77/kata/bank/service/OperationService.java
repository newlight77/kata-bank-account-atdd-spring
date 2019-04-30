package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    @Autowired
    private AccountService accountService;

    public double deposit(String accountId, Double money) {
        Account account = accountService.getAccount(accountId);
        double balance = account.getBalance() + money;
        account.setBalance(balance);
        return balance;
    }
}
