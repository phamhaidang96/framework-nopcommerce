package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Add New button")
	public void clickToAddNewButton() {
		waitForElementClickable(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
	}

	@Step("Input to First name textbox with value is '" + "{0}'")
	public void inputToFirstNameTextbox(String addressFisrtName) {
		waitForElementVisible(driver, UserAddressesPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.FIRST_NAME_TEXTBOX, addressFisrtName);
	}

	@Step("Input to Last name textbox with value is '" + "{0}'")
	public void inputToLastNameTextbox(String addressLastName) {
		waitForElementVisible(driver, UserAddressesPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.LAST_NAME_TEXTBOX, addressLastName);
	}

	@Step("Input to Email textbox with value is '" + "{0}'")
	public void inputToEmailTextbox(String addressEmail) {
		waitForElementVisible(driver, UserAddressesPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.EMAIL_TEXTBOX, addressEmail);
	}

	@Step("Input to Company textbox with value is '" + "{0}'")
	public void inputToCompanyTextbox(String addressCompany) {
		waitForElementVisible(driver, UserAddressesPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.COMPANY_TEXTBOX, addressCompany);
	}

	@Step("Select Country dropdown with value is '" + "{0}'")
	public void selectCountryDropdown(String addressCountry) {
		waitForElementVisible(driver, UserAddressesPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserAddressesPageUI.COUNTRY_DROPDOWN, addressCountry);
	}

	@Step("Select State dropdown with value is '" + "{0}'")
	public void selectStateDropdown(String addressState) {
		waitForElementUndisplay(driver, UserAddressesPageUI.STATES_LOADING_ICON);
		selectItemInDefaultDropdown(driver, UserAddressesPageUI.STATE_DROPDOWN, addressState);
	}

	@Step("Input to City textbox with value is '" + "{0}'")
	public void inputToCityTextbox(String addressCity) {
		waitForElementVisible(driver, UserAddressesPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.CITY_TEXTBOX, addressCity);
	}

	@Step("Input to Address1 textbox with value is '" + "{0}'")
	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS1_TEXTBOX, address1);
	}

	@Step("Input to Address2 textbox with value is '" + "{0}'")
	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS2_TEXTBOX, address2);
	}

	@Step("Input to Zip code textbox with value is '" + "{0}'")
	public void inputToZipcodeTextbox(String addressZipcode) {
		waitForElementVisible(driver, UserAddressesPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ZIPCODE_TEXTBOX, addressZipcode);
	}

	@Step("Input to Phone number textbox with value is '" + "{0}'")
	public void inputToPhoneNumberTextbox(String addressPhoneNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.PHONE_NUMNER_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.PHONE_NUMNER_TEXTBOX, addressPhoneNumber);
	}

	@Step("Input to Fax number textbox with value is '" + "{0}'")
	public void inputToFaxNumberTextbox(String addressFaxNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.FAX_NUMNER_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.FAX_NUMNER_TEXTBOX, addressFaxNumber);
	}

	@Step("Click to Save button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, UserAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressesPageUI.SAVE_BUTTON);
	}

	@Step("Verify Add address success message is displayed")
	public String getAddAddressSuccessMessage() {
		waitForElementVisible(driver, UserAddressesPageUI.ADD_ADDRESS_SUCCESS_MESSAGE);
		return getElementText(driver, UserAddressesPageUI.ADD_ADDRESS_SUCCESS_MESSAGE);
	}

	@Step("Verify First name and Last name is displayed")
	public String isFirstNameAndLastNameDisplayed() {
		waitForElementVisible(driver, UserAddressesPageUI.FIRST_NAME_AND_LAST_NAME_INFO);
		return getElementText(driver, UserAddressesPageUI.FIRST_NAME_AND_LAST_NAME_INFO);
	}

	@Step("Verify Email is displayed")
	public Boolean isEmailDisplayed(String email) {
		waitForElementVisible(driver, UserAddressesPageUI.EMAIL_INFO);
		return isContainTextDisplayed(driver, UserAddressesPageUI.EMAIL_INFO, email);
	}

	@Step("Verify Company name is displayed")
	public String isCompanyDisplayed() {
		waitForElementVisible(driver, UserAddressesPageUI.COMPANY_INFO);
		return getElementText(driver, UserAddressesPageUI.COMPANY_INFO);
	}

	@Step("Verify Country is displayed")
	public String isCountryDisplayed() {
		waitForElementVisible(driver, UserAddressesPageUI.COUNTRY_INFO);
		return getElementText(driver, UserAddressesPageUI.COUNTRY_INFO);
	}

	@Step("Verify City, State and Zip name is displayed")
	public String isCityStateZipDisplayed() {
		waitForElementVisible(driver, UserAddressesPageUI.CITY_STATE_ZIP_INFO);
		return getElementText(driver, UserAddressesPageUI.CITY_STATE_ZIP_INFO);
	}

	@Step("Verify Address1 is displayed")
	public String isAddress1Displayed() {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS1_INFO);
		return getElementText(driver, UserAddressesPageUI.ADDRESS1_INFO);
	}

	@Step("Verify Address2 is displayed")
	public String isAddress2Displayed() {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS2_INFO);
		return getElementText(driver, UserAddressesPageUI.ADDRESS2_INFO);
	}

	@Step("Verify Phone number is displayed")
	public boolean isPhoneNumberDisplayed(String phoneNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.PHONE_INFO);
		return isContainTextDisplayed(driver, UserAddressesPageUI.PHONE_INFO, phoneNumber);
	}

	@Step("Verify Fax number is displayed")
	public boolean isFaxNumberDisplayed(String faxNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.FAX_INFO);
		return isContainTextDisplayed(driver, UserAddressesPageUI.FAX_INFO, faxNumber);
	}
}
