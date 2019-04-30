package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.exception.NotAllowedException;
import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountService {

    private Map<String, Account> accounts = new HashMap<>();

    public Account create(Client client) {
        if (Country.FRANCE.equals(client.getCountry())) {
            Account account =  Account.builder()
                    .id(UUID.randomUUID())
                    .client(client)
                    .balance(0)
                    .build();
            accounts.put(account.getId().toString(), account);
            return account;
        }
        throw new NotAllowedException("not allowed");
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }
}
