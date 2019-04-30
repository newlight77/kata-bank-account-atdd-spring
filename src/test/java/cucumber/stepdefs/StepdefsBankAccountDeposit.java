package cucumber.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdefsBankAccountDeposit {

    @Given("^a client having an account$")
    public void a_client_having_an_account() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the balance in that account is (\\d*\\.?\\d+)$")
    public void the_balance_in_that_account_is(double balance) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^he want to deposit his pocket money in his account$")
    public void he_want_to_deposit_his_pocket_money_in_his_account() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the new balance is updated with (\\d*\\.?\\d+)$")
    public void the_new_balance_is_updated_with(double newBalance) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the deposit is not allowed$")
    public void the_deposit_is_not_allowed() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

//    @Then("^an (.*) message is shown$")
//    public void an_error_message_is_shown(String message) throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
