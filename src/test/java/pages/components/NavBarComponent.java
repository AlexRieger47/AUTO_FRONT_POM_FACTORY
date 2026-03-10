package pages.components;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class NavBarComponent extends PageObject {

	@FindBy(css = "a[href='/tickets']")
	private WebElementFacade ticketsLink;

	@FindBy(css = "a[href='/tickets/new']")
	private WebElementFacade createTicketLink;

	@FindBy(css = "button.navbar__link--logout")
	private WebElementFacade logoutButton;

	public void goToTickets() {
		ticketsLink.waitUntilClickable().click();
	}

	public void goToCreateTicket() {
		createTicketLink.waitUntilClickable().click();
	}

	public boolean isDisplayed() {
		return ticketsLink.waitUntilVisible().isVisible() && logoutButton.isVisible();
	}
}
