package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	private WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input to Old password with value is '{0}'")
	public void inputToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
	}

	@Step("Input to New password with value is '{0}'")
	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	@Step("Input to Confirm password with value is '{0}'")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	@Step("Click to Change password button")
	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	@Step("Get change password success message")
	public String getChangePasswordSuccessMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return getElementText(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}

	@Step("Close change password success message")
	public void closeChangePasswordSuccessMessage() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_CLOSE_ICON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_CLOSE_ICON);
		waitForElementUndisplay(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_CLOSE_ICON);
	}
}
