package com.newlight77.kata.bank.controller;

import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Client client) {
        return accountService.create(client);
    }
}
