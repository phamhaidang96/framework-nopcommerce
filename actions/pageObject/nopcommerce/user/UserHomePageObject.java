package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Open 'Register' page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
}
