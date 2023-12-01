package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserComputersPageUI;

public class UserComputersPageObject extends BasePage {
	WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Open {0}'s list product")
	public void openSublistProductAtHeaderMenuByName(String productSublistName) {
		waitForElementClickable(driver, UserComputersPageUI.COMPUTERS_HEADER_MENU);
		hoverMouseToElement(driver, UserComputersPageUI.COMPUTERS_HEADER_MENU);

		waitForElementVisible(driver, UserComputersPageUI.DYNAMIC_PRODUCT_SUBLIST_AT_HEADER_MENU, productSublistName);
		clickToElement(driver, UserComputersPageUI.DYNAMIC_PRODUCT_SUBLIST_AT_HEADER_MENU, productSublistName);
	}

	@Step("Click to first product title")
	public void clickToFirstProductTitle() {
		waitForElementClickable(driver, UserComputersPageUI.FIRST_PRODUCT_TITLE);
		clickToElement(driver, UserComputersPageUI.FIRST_PRODUCT_TITLE);
	}
}
