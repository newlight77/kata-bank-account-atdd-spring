package cucumber.stepdefs;

import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdefsBankAccountCreation {

    private Client client;

    @Given("^a client who's lastname is (.*) and firstname is (.*)$")
    public void a_client_who_s_lastname_is_and_firstname_is(String lastname, String firstname) throws Exception {
        client = Client
                .builder()
                .firstName(firstname)
                .lastName(lastname)
                .build();
    }

    @Given("^he has (\\-?\\d*\\.?\\d+) in his wallet$")
    public void he_has_in_his_wallet(double money) throws Exception {
        client.setWallet(money);
    }

    @Given("^he lives in (.*)")
    public void he_lives_in(String country) throws Exception {
        client.setCountry(Country.valueOf(country));
     }

    @When("^he want to create a bank account with his money$")
    public void he_want_to_create_a_bank_account_with_his_money() throws Exception {
        throw new PendingException();

    }

    @Then("^the account is created under his name with an initial balance of (\\-?\\d*\\.?\\d+)$")
    public void the_account_is_created_under_his_name_with_an_initial_balance_of(double initialBalance) throws Exception {
        throw new PendingException();

    }

    @Then("^the account is not created$")
    public void the_account_is_not_created() throws Exception {
        throw new PendingException();

    }

    @Then("^an no allowed is shown$")
    public void an_no_allowed_is_shown() throws Exception {
        throw new PendingException();

    }
}
