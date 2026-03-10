package pages.tickets;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CreateTicketPage extends PageObject {

	@FindBy(css = "form.ticket-form input.form-input")
	private WebElementFacade titleInput;

	@FindBy(css = "form.ticket-form textarea.form-textarea")
	private WebElementFacade descriptionTextarea;

	@FindBy(css = "form.ticket-form button.form-button")
	private WebElementFacade submitButton;

	public void enterTitle(String title) {
		titleInput.waitUntilVisible().type(title);
	}

	public void enterDescription(String description) {
		descriptionTextarea.waitUntilVisible().type(description);
	}

	public void submitTicket() {
		submitButton.waitUntilClickable().click();
	}

	public void createTicket(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		submitTicket();
	}
}
