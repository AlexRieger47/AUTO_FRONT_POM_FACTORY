package pages.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

	@FindBy(id = "email")
	private WebElementFacade emailField;

	@FindBy(id = "password")
	private WebElementFacade passwordField;

	@FindBy(css = "button.btn-primary")
	private WebElementFacade loginButton;

	public void enterEmail(String email) {
		emailField.waitUntilVisible().type(email);
	}

	public void enterPassword(String password) {
		passwordField.waitUntilVisible().type(password);
	}

	public void clickLogin() {
		loginButton.waitUntilClickable().click();
	}

	public void loginAs(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	}
}
