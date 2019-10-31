Feature: Withdrawal from an ATM
  A client wants to withdrawal money at an ATM

  @Withdraw
  Scenario Outline: Withdrawal money from an ATM that contains enough money
    Given a client having a valid account
    And the account balance is <init_balance> euros
    And the card is valid
    And the ATM contains enough money
    When the account holder requests <money> euros
    Then the ATM should dispense <money> euros
    And the account balance should be <new_balance> euros
    And the card should be returned

    Examples:
    | init_balance | money   | new_balance |
    | 100.0        | 20.0    | 80.0        |
