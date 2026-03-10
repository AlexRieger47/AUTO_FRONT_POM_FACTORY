package pages.tickets;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TicketListPage extends PageObject {

	@FindBy(css = ".list-header")
	private WebElementFacade pageHeader;

	@FindBy(css = ".tickets-grid")
	private WebElementFacade ticketItemsContainer;

	@FindBy(css = ".ticket-item .ticket-title")
	private List<WebElementFacade> ticketTitles;

	public boolean isTicketListDisplayed() {
		return pageHeader.waitUntilVisible().isVisible();
	}

	public boolean isTicketVisible(String ticketTitle) {
		for (WebElementFacade titleElement : ticketTitles) {
			if (titleElement.waitUntilVisible().getText().trim().equals(ticketTitle)) {
				return true;
			}
		}
		return false;
	}

	public void waitForTicketList() {
		ticketItemsContainer.waitUntilVisible();
	}
}
