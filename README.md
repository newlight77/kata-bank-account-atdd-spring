# Kata-Bank-Account-ATDD

[![Build Status](https://travis-ci.org/newlight77/kata-bank-account-atdd-spring.svg?branch=master)](https://travis-ci.org/newlight77/kata-bank-account-atdd-spring)
[![Maintainability](https://api.codeclimate.com/v1/badges/5215148bf0b74c26470a/maintainability)](https://codeclimate.com/github/newlight77/kata-bank-account-atdd-spring/maintainability)
[![codecov](https://codecov.io/gh/newlight77/kata-bank-account-atdd-spring/branch/master/graph/badge.svg)](https://codecov.io/gh/newlight77/kata-bank-account-atdd-spring)
[![BetterCodeHub compliance](https://bettercodehub.com/edge/badge/newlight77/kata-bank-account-atdd-spring?branch=master)](https://bettercodehub.com/)

## Kata Statement

Bank Account kata for practice TDD implemented by [Jorge Sánchez (Xurxodev)](https://github.com/xurxodev/Bank-Account-Kata/blob/master/README.md)

Think of your personal bank account experience.

When in doubt, go for the simplest solution

### Requirements

These are requirements for kata.

#### Initial requirements

* Deposit (negative not permitted)
* Withdrawal (negative not permitted)  
* GetBalance  
* Account statement (date, quantity, balance) 
* Statement printing 

#### Extra requirements if you feel with force :)

* Deposit and Withdrawal (EUR and USD)

## My Approach

### Technical stack 

I'm using Springboot, Java and Cucumber. 

From the original statement, I decided to add account creation feature.

### Story Mapping

Let's translate the features above into user stories :

* US1 : Create an account (not allow non-resident of France)
* US2 : Deposit (negative not permitted)
* US3 : Withdrawal (negative not permitted)  
* US4 : GetBalance  
* US5 : Account statement (date, quantity, balance) 
* US6 : Statement printing

## Run it

```bash
./mvnw clean test
```

