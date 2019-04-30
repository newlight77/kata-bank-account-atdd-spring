package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.exception.NotAllowedException;
import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Account create(Client client) {
        if (Country.FRANCE.equals(client.getCountry())) {
            return Account.builder().client(client).build();
        }
        throw new NotAllowedException("not allowed");
    }
}
