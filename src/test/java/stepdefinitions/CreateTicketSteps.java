package stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.components.NavBarComponent;
import pages.login.LoginPage;
import pages.tickets.CreateTicketPage;
import pages.tickets.TicketListPage;
import utils.TestData;

public class CreateTicketSteps {

	LoginPage loginPage;
	NavBarComponent navBarComponent;
	CreateTicketPage createTicketPage;
	TicketListPage ticketListPage;

	private String ticketTitle;

	@Given("el usuario se encuentra autenticado en el modulo de tickets")
	public void elUsuarioSeEncuentraAutenticadoEnElModuloDeTickets() {
		loginPage.openUrl(TestData.getBaseUrl() + "/login");
		loginPage.loginAs(TestData.DEFAULT_EMAIL, TestData.DEFAULT_PASSWORD);
		assertThat(ticketListPage.isTicketListDisplayed()).isTrue();
	}

	@When("el usuario registra un nuevo ticket con titulo y descripcion validos")
	public void elUsuarioRegistraUnNuevoTicketConTituloYDescripcionValidos() {
		ticketTitle = TestData.generateUniqueTicketTitle();
		String ticketDescription = TestData.generateTicketDescription();
		navBarComponent.goToCreateTicket();
		createTicketPage.createTicket(ticketTitle, ticketDescription);
	}

	@Then("el ticket queda disponible en el listado de tickets")
	public void elTicketQuedaDisponibleEnElListadoDeTickets() {
		ticketListPage.waitForTicketList();
		assertThat(ticketListPage.isTicketVisible(ticketTitle)).isTrue();
	}
}
