Feature: Deposit in Bank Account
  A client wants to deposit his money in his account

  @Deposit
  Scenario Outline: Deposit money with positif amount
    Given a client having an account
    And the balance in that account is <init_balance>
    And he has <money> in his wallet
    When he want to deposit his pocket money in his account
    Then the new balance is updated with <balance>

    Examples:
    | init_balance | money   | balance |
    | 100.0          | 50.0      | 150.0   |

  @Deposit
  Scenario Outline: Deposit money with negative amount
    Given a client having an account
    And the balance in that account is <init_balance>
    And he has <money> in his wallet
    When he want to deposit his pocket money in his account
    Then the deposit is not allowed
    And an error message <error_message> is shown

    Examples:
      | init_balance | money   | balance |  error_message         |
      | 100.0          | -150.0    | 150.0   |  not allowed |
