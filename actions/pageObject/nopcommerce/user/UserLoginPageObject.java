package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Login button")
	public void clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	}

	@Step("Get email error message at email textbox")
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("Input to 'Email' textbox with value is '" + "{0}'")
	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, invalidEmail);
	}

	@Step("Get login unsuccessful error message")
	public String getLoginUnsuccessfulErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);
	}

	@Step("Input to 'Password' textbox with value is '" + "{0}'")
	public void inputToPasswordTextbox(String incorrectPassword) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, incorrectPassword);
	}

	@Step("Verrify 'My Account' link is display")
	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, UserLoginPageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserLoginPageUI.MY_ACCOUNT_LINK);
	}

	@Step("Login to Sytem with Email is '" + "{0}'" + "and Password is'" + "{1}'")
	public UserHomePageObject LoginToSystem(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		clickToLoginButton();
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
