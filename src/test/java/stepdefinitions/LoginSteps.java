package stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login.LoginPage;
import pages.tickets.TicketListPage;
import utils.TestData;

public class LoginSteps {

	LoginPage loginPage;
	TicketListPage ticketListPage;

	@Given("existe un usuario registrado con credenciales validas en SistemaTickets")
	public void existeUnUsuarioRegistradoConCredencialesValidasEnSistemaTickets() {
		loginPage.openUrl(TestData.getBaseUrl() + "/login");
	}

	@When("el usuario inicia sesion en SistemaTickets")
	public void elUsuarioIniciaSesionEnSistemaTickets() {
		loginPage.loginAs(TestData.DEFAULT_EMAIL, TestData.DEFAULT_PASSWORD);
	}

	@Then("el usuario visualiza el listado de tickets")
	public void elUsuarioVisualizaElListadoDeTickets() {
		assertThat(ticketListPage.isTicketListDisplayed()).isTrue();
	}
}
