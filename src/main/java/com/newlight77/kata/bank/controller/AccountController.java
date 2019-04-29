package com.newlight77.kata.bank.controller;

import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    @Autowired
    private ClientService clientService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }
}
