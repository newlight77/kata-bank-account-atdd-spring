Feature: Bank account creation
  A client wants to create a bank account

  @Account
  Scenario Outline: Create an account with his money
    Given a client who's lastname is <lastname> and firstname is <firstname>
    And he has <money> in his wallet
    And he lives in <country>
    When he want to create a bank account with his money
    Then the account is created under his name with an initial balance of <balance>

    Examples:
    | lastname | firstname | money   | country   | balance |
    | To       | Kong      | 100.0   | FRANCE    | 100.0   |
    | King     | Kong      | 10.0    | FRANCE    | 10.0    |

  @Account
  Scenario Outline: Create an account not allowed for non resident of FRANCE
    Given a client who's lastname is <lastname> and firstname is <firstname>
    And he has <money> in his wallet
    And he lives in <country>
    When he want to create a bank account with his money
    Then the account is not created
    And an <error_message> is shown

    Examples:
    | lastname | firstname | money   | country     | error_message |
    | To       | Kong      | 100.0   | PORTUGAL    | no allowed    |
    | King     | Kong      | 100.0   | INDIA       | no allowed    |
    | King     | Kong      | 100.0   | ITALY       | no allowed    |