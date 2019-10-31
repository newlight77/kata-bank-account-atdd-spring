package cucumber.stepdefs;

import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import com.newlight77.kata.bank.service.AccountService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class StepdefsBankAccountDeposit {

    @Autowired
    private AccountService accountService;

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:";
    private StepDefsContext context = StepDefsContext.CONTEXT;

    @Given("a client having an account")
    public void a_client_having_an_account() throws Exception {
        Client client = Client
                .builder()
                .country(Country.FRANCE)
                .build();

        context.givenObject(client);
        Account account = accountService.create(client);
        context.givenObject(account);
    }

    @Given("the balance in that account is {double}")
    public void the_balance_in_that_account_is(double balance) throws Exception {
        context.givenObject(Account.class).setBalance(balance);
    }

    @When("he want to deposit his pocket money in his account")
    public void he_want_to_deposit_his_pocket_money_in_his_account() throws Exception {
        final String url = baseUrl + port + "/api/v1/operations";

        Response response = given().log()
                .all()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("accountId", context.givenObject(Account.class).getId())
                .body(context.givenObject(Client.class).getWallet())
                .post(url)
                .andReturn();

        response.then()
                .log()
                .all();

        context.response(response);
    }

    @Then("the new balance is updated with {double}")
    public void the_new_balance_is_updated_with(double newBalance) throws Exception {
        assertThat(context.response().getStatusCode()).isBetween(200, 201);
        assertThat(context.response().getBody()).isNotNull();
        assertThat(context.response().getBody().as(Double.class)).isEqualTo(newBalance);
    }

    @Then("the deposit is not allowed")
    public void the_deposit_is_not_allowed() throws Exception {
        assertThat(context.response().getStatusCode()).isBetween(400, 404);
    }

}
