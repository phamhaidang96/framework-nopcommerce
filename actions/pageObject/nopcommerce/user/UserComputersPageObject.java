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

	@Step("Select to Sort by dropdown by option '{0}'")
	public void selectToSortByDropdownByOption(String sortType) {
		waitForElementVisible(driver, UserComputersPageUI.SORT_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserComputersPageUI.SORT_BY_DROPDOWN, sortType);
		waitForElementUndisplay(driver, UserComputersPageUI.PRODUCT_BUSY_LOADING_ICON);
	}

	@Step("Verify product sort by Name Acsending")
	public boolean isProductSortByNameAcsending() {
		ArrayList<String> productUIList = new ArrayList<String>();

		waitForAllElementVisible(driver, UserComputersPageUI.PRODUCTS_NAME);
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

	@Step("Verify product sort by Name Descending")
	public boolean isProductSortByNameDescending() {
		ArrayList<String> productUIList = new ArrayList<String>();

		waitForAllElementVisible(driver, UserComputersPageUI.PRODUCTS_NAME);
		List<WebElement> productNames = getListWebElement(driver, UserComputersPageUI.PRODUCTS_NAME);
		for (WebElement productName : productNames) {
			productUIList.add(productName.getText());
		}

		ArrayList<String> sortProductUIList = new ArrayList<String>();
		for (String product : productUIList) {
			sortProductUIList.add(product);
		}

		Collections.sort(sortProductUIList);
		Collections.reverse(sortProductUIList);

		return sortProductUIList.equals(productUIList);
	}

	@Step("Verify product sort by Price Acsending")
	public boolean isProductSortByPriceAcsending() {
		ArrayList<Float> productsUIList = new ArrayList<Float>();

		waitForAllElementVisible(driver, UserComputersPageUI.PRODUCTS_PRICE);
		List<WebElement> productsPrice = getListWebElement(driver, UserComputersPageUI.PRODUCTS_PRICE);
		for (WebElement productPrice : productsPrice) {
			productsUIList.add(Float.parseFloat(productPrice.getText().substring(1).replace(",", "")));
		}

		ArrayList<Float> sortproductsUIList = new ArrayList<Float>();
		for (Float product : productsUIList) {
			sortproductsUIList.add(product);
		}

		Collections.sort(sortproductsUIList);

		return sortproductsUIList.equals(productsUIList);
	}

	@Step("Verify product sort by Price Descending")
	public boolean isProductSortByPriceDescending() {
		ArrayList<Float> productsUIList = new ArrayList<Float>();

		waitForAllElementVisible(driver, UserComputersPageUI.PRODUCTS_PRICE);
		List<WebElement> productsPrice = getListWebElement(driver, UserComputersPageUI.PRODUCTS_PRICE);
		for (WebElement productPrice : productsPrice) {
			productsUIList.add(Float.parseFloat(productPrice.getText().substring(1).replace(",", "")));
		}

		ArrayList<Float> sortproductsUIList = new ArrayList<Float>();
		for (Float product : productsUIList) {
			sortproductsUIList.add(product);
		}

		Collections.sort(sortproductsUIList);
		Collections.reverse(sortproductsUIList);

		return sortproductsUIList.equals(productsUIList);
	}

	@Step("Select to Display per page dropdown with value is '{0}'")
	public void selectToDisplayPerPageDropdownByOption(String pageSize) {
		waitForElementVisible(driver, UserComputersPageUI.PRODUCTS_PAGE_SIZE_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserComputersPageUI.PRODUCTS_PAGE_SIZE_DROPDOWN, pageSize);
		waitForElementUndisplay(driver, UserComputersPageUI.PRODUCT_BUSY_LOADING_ICON);
	}

	@Step("Verify display 3 product per page")
	public boolean isDisplayThreeProductPerPage() {
		waitForAllElementVisible(driver, UserComputersPageUI.PRODUCTS_NAME);
		List<WebElement> productName = getListWebElement(driver, UserComputersPageUI.PRODUCTS_NAME);
		if (productName.size() <= 3) {
			return true;
		} else {
			return false;
		}
	}

	@Step("Verify Next paging icon displayed")
	public boolean isNextPagingIconDisplay() {
		waitForElementVisible(driver, UserComputersPageUI.NEXT_PAGING_ICON);
		return isElementDisplayed(driver, UserComputersPageUI.NEXT_PAGING_ICON);
	}

	@Step("Click to Next paging icon")
	public void clickToNextPagingIcon() {
		waitForElementClickable(driver, UserComputersPageUI.NEXT_PAGING_ICON);
		clickToElement(driver, UserComputersPageUI.NEXT_PAGING_ICON);
	}

	@Step("Verify Previous paging icon displayed")
	public boolean isPreviousPagingIconDisplay() {
		waitForElementVisible(driver, UserComputersPageUI.PREVIOUS_PAGING_ICON);
		return isElementDisplayed(driver, UserComputersPageUI.PREVIOUS_PAGING_ICON);
	}
}
