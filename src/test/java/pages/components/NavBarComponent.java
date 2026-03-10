package pages.components;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class NavBarComponent extends PageObject {

    private static final By CREATE_TICKET_LINK = By.linkText("Create Ticket");
    private static final By TICKET_LIST_LINK = By.linkText("Ticket List");
    private static final By LOGOUT_LINK = By.linkText("Logout");

    public void clickCreateTicket() {
        $(CREATE_TICKET_LINK).click();
    }

    public void clickTicketList() {
        $(TICKET_LIST_LINK).click();
    }

    public void clickLogout() {
        $(LOGOUT_LINK).click();
    }

    public boolean isDisplayed() {
        return $(CREATE_TICKET_LINK).isDisplayed();
    }
}
