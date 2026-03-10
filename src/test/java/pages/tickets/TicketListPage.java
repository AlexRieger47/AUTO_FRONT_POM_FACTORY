package pages.tickets;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("/tickets")
public class TicketListPage extends PageObject {

    @FindBy(css = ".ticket-item .ticket-title")
    private List<WebElementFacade> ticketTitles;

    @FindBy(css = ".create-ticket-btn")
    private WebElementFacade createTicketButton;

    public void clickCreateTicket() {
        createTicketButton.click();
    }

    public boolean isTicketVisible(String title) {
        return ticketTitles.stream()
                .anyMatch(ticket -> ticket.getText().contains(title));
    }

    public boolean isOnTicketListPage() {
        return containsElements(By.cssSelector(".ticket-list"));
    }
}
