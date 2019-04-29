package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.exception.NotAllowedException;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public Client create(Client client) {
        if (Country.FRANCE.equals(client.getCountry())) {
            return client;
        }
        throw new NotAllowedException("not allowed");
    }
}
