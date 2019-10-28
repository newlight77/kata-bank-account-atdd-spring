package com.newlight77.kata.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private Long number;
    private String name;
    private Integer expirationYear;
    private Integer expirationMongth;
    private Integer code;
}
