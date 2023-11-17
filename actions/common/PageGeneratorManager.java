package common;

import org.openqa.selenium.WebDriver;

import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
}
