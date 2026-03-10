package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.components.NavBarComponent;
import pages.tickets.CreateTicketPage;
import pages.tickets.TicketListPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTicketSteps {

    @Steps
    private NavBarComponent navBar;

    @Steps
    private CreateTicketPage createTicketPage;

    @Steps
    private TicketListPage ticketListPage;

    @When("the user navigates to create a new ticket")
    public void theUserNavigatesToCreateANewTicket() {
        createTicketPage.open();
    }

    @And("the user fills in the ticket title {string}")
    public void theUserFillsInTheTicketTitle(String title) {
        createTicketPage.enterTitle(title);
    }

    @And("the user fills in the ticket description {string}")
    public void theUserFillsInTheTicketDescription(String description) {
        createTicketPage.enterDescription(description);
    }

    @And("the user submits the ticket")
    public void theUserSubmitsTheTicket() {
        createTicketPage.submitTicket();
    }

    @Then("the ticket {string} should be visible in the ticket list")
    public void theTicketShouldBeVisibleInTheTicketList(String title) {
        assertThat(ticketListPage.isTicketVisible(title)).isTrue();
    }
}
