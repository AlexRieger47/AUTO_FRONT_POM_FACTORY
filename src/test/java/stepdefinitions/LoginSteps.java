package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.login.LoginPage;
import pages.tickets.TicketListPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    @Steps
    private LoginPage loginPage;

    @Steps
    private TicketListPage ticketListPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.open();
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        loginPage.loginAs(username, password);
    }

    @Then("the user should be redirected to the ticket list page")
    public void theUserShouldBeRedirectedToTheTicketListPage() {
        assertThat(ticketListPage.isOnTicketListPage()).isTrue();
    }

    @Given("the user is logged in with username {string} and password {string}")
    public void theUserIsLoggedInWithUsernameAndPassword(String username, String password) {
        loginPage.open();
        loginPage.loginAs(username, password);
    }
}
