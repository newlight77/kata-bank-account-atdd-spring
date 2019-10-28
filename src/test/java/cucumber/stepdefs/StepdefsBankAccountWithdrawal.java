package cucumber.stepdefs;

import com.newlight77.kata.bank.model.*;
import com.newlight77.kata.bank.service.AccountService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import javax.naming.OperationNotSupportedException;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class StepdefsBankAccountWithdrawal {

    @Autowired
    private AccountService accountService;

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:";
    private StepDefsContext context = StepDefsContext.CONTEXT;

    @Given("^a client having a valid account$")
    public void aClientHavingAValidAccount() {
        Client client = Client
                .builder()
                .country(Country.FRANCE)
                .build();

        context.givenObject(client);
        Account account = accountService.create(client);
        context.givenObject(account);
    }

    @Given("^the account balance is (\\-?\\d*\\.?\\d+) euros$")
    public void the_account_balance_is_euros(double initialBalance) throws Exception {
        context.givenObject(Account.class).setBalance(initialBalance);
    }

    @Given("^the card is valid$")
    public void the_card_is_valid() throws Exception {
        Card card = Card.builder()
                .number(123456789L)
                .name("Kong To")
                .expirationMongth(11)
                .expirationYear(2022)
                .code(444)
                .build();
        context.givenObject(card);
    }

    @Given("^the ATM contains enough money$")
    public void the_ATM_contains_enough_money() throws Exception {
        Atm atm = Atm.builder()
                .id(UUID.randomUUID())
                .balance(1000L)
                .cardHold(true)
                .build();
        context.givenObject(atm);
    }

    @When("^the account holder requests (\\-?\\d*\\.?\\d+) euros$")
    public void the_account_holder_requests_euros(double amount) throws Exception {
        final String url = baseUrl + port + "/api/v1/operations/withdrawal";

        Operation operation = Operation.builder()
                .account(context.givenObject(Account.class))
                .atm(context.givenObject(Atm.class))
                .card(context.givenObject(Card.class))
                .amount(amount)
                .type("withdrawl")
                .status("pending")
                .build();

        Response response = given().log()
                .all()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("accountId", context.givenObject(Account.class).getId())
                .body(operation)
                .post(url)
                .andReturn();

        response.then()
                .log()
                .all();

        context.response(response);
    }

    @Then("^the ATM should dispense (\\-?\\d*\\.?\\d+) euros$")
    public void the_ATM_should_dispense_euros(double amount) throws Exception {
        double atmBalance = context.response().getBody().as(Transaction.class).getAtm().getBalance();
        assertThat(atmBalance).isEqualTo(1000L - amount);
    }

    @Then("^the account balance should be (\\-?\\d*\\.?\\d+) euros$")
    public void the_account_balance_should_be_euros(double newBalance) throws Exception {
        assertThat(context.response().getStatusCode()).isBetween(200, 201);
        assertThat(context.response().getBody()).isNotNull();
        assertThat(context.response().getBody().as(Transaction.class).getAccount().getBalance()).isEqualTo(newBalance);
    }

    @Then("^the card should be returned$")
    public void the_card_should_be_returned() throws Exception {
        assertThat(context.response().getBody().as(Transaction.class).getAtm().isCardHold()).isFalse();
    }
}
