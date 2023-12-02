package pageObject.nopcommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserComputersPageUI;

public class UserComputersPageObject extends BasePage {
	WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Open {0}'s list product")
	public void openPageAtMenuComputersSublistByName(String productSublistName) {
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

	@Step("Click to Sort by dropdown by option '{0}'")
	public void selectToSortByDropdownByOption(String sortType) {
		waitForElementVisible(driver, UserComputersPageUI.SORT_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserComputersPageUI.SORT_BY_DROPDOWN, sortType);
	}

	@Step("Verify product sort by Name Acsending")
	public boolean isProductSortByNameAcsending() {
		ArrayList<String> productUIList = new ArrayList<String>();

		waitForElementUndisplay(driver, UserComputersPageUI.PRODUCT_BUSY_LOADING_ICON);
		List<WebElement> productNames = getListWebElement(driver, UserComputersPageUI.PRODUCTS_NAME);

		for (WebElement productName : productNames) {
			productUIList.add(productName.getText());
		}

		ArrayList<String> sortProductUIList = new ArrayList<String>();
		for (String product : productUIList) {
			sortProductUIList.add(product);
		}

		Collections.sort(sortProductUIList);

		return sortProductUIList.equals(productUIList);
	}
}
