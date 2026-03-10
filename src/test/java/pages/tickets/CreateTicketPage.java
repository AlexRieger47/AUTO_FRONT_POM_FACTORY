package pages.tickets;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("/tickets/new")
public class CreateTicketPage extends PageObject {

    @FindBy(id = "ticket-title")
    private WebElementFacade titleField;

    @FindBy(id = "ticket-description")
    private WebElementFacade descriptionField;

    @FindBy(id = "submit-ticket")
    private WebElementFacade submitButton;

    public void enterTitle(String title) {
        titleField.clear();
        titleField.type(title);
    }

    public void enterDescription(String description) {
        descriptionField.clear();
        descriptionField.type(description);
    }

    public void submitTicket() {
        submitButton.click();
    }
}
