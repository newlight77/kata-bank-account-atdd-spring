package com.newlight77.kata.bank.controller;

import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Card;
import com.newlight77.kata.bank.model.Operation;
import com.newlight77.kata.bank.model.Transaction;
import com.newlight77.kata.bank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Double deposit(@RequestParam String accountId, @RequestBody Double money) {
        return operationService.deposit(accountId, money);
    }

    @PostMapping("withdrawal")
    @ResponseStatus(HttpStatus.OK)
    public Transaction deposit(@RequestBody Operation operation) throws IllegalAccessException {
        if (operation.getCard() == null) {
            throw new IllegalAccessException("card is not valid");
        }
        return operationService.withdrawal(operation);
    }
}
