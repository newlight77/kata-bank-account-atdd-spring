package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.exception.NotAllowedException;
import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Operation;
import com.newlight77.kata.bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OperationService {
    @Autowired
    private AccountService accountService;

    public double deposit(String accountId, Double money) {
        if (money < 0) {
            throw new NotAllowedException("not allowed");
        }

        Account account = accountService.getAccount(accountId);
        double balance = account.getBalance() + money;
        account.setBalance(balance);
        return balance;
    }

    public Transaction withdrawal(Operation operation) {
        if (operation.getAmount() < 0) {
            throw new NotAllowedException("not allowed");
        }

        double balance = operation.getAccount().getBalance() - operation.getAmount();
        operation.getAccount().setBalance(balance);

        operation.getAtm().setBalance(operation.getAtm().getBalance()-operation.getAmount());
        operation.getAtm().setCardHold(false);

        return Transaction.builder()
                .account(operation.getAccount())
                .atm(operation.getAtm())
                .date(new Date())
                .amount(- operation.getAmount())
                .status("completed")
                .build();
    }
}
