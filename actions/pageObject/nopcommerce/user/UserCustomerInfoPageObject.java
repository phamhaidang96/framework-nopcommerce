package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
