package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.userAddressesPageUI;

public class UserAddressesPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Add New button")
	public void clickToAddNewButton() {
		waitForElementClickable(driver, userAddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, userAddressesPageUI.ADD_NEW_BUTTON);
	}

	@Step("Input to First name textbox with value is '" + "{0}'")
	public void inputToFirstNameTextbox(String addressFisrtName) {
		waitForElementVisible(driver, userAddressesPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.FIRST_NAME_TEXTBOX, addressFisrtName);
	}

	@Step("Input to Last name textbox with value is '" + "{0}'")
	public void inputToLastNameTextbox(String addressLastName) {
		waitForElementVisible(driver, userAddressesPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.LAST_NAME_TEXTBOX, addressLastName);
	}

	@Step("Input to Email textbox with value is '" + "{0}'")
	public void inputToEmailTextbox(String addressEmail) {
		waitForElementVisible(driver, userAddressesPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.EMAIL_TEXTBOX, addressEmail);
	}

	@Step("Input to Company textbox with value is '" + "{0}'")
	public void inputToCompanyTextbox(String addressCompany) {
		waitForElementVisible(driver, userAddressesPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.COMPANY_TEXTBOX, addressCompany);
	}

	@Step("Select Country dropdown with value is '" + "{0}'")
	public void selectCountryDropdown(String addressCountry) {
		waitForElementVisible(driver, userAddressesPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, userAddressesPageUI.COUNTRY_DROPDOWN, addressCountry);
	}

	@Step("Select State dropdown with value is '" + "{0}'")
	public void selectStateDropdown(String addressState) {
		waitForElementUndisplay(driver, userAddressesPageUI.STATES_LOADING_ICON);
		selectItemInDefaultDropdown(driver, userAddressesPageUI.STATE_DROPDOWN, addressState);
	}

	@Step("Input to City textbox with value is '" + "{0}'")
	public void inputToCityTextbox(String addressCity) {
		waitForElementVisible(driver, userAddressesPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.CITY_TEXTBOX, addressCity);
	}

	@Step("Input to Address1 textbox with value is '" + "{0}'")
	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, userAddressesPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.ADDRESS1_TEXTBOX, address1);
	}

	@Step("Input to Address2 textbox with value is '" + "{0}'")
	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, userAddressesPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.ADDRESS2_TEXTBOX, address2);
	}

	@Step("Input to Zip code textbox with value is '" + "{0}'")
	public void inputToZipcodeTextbox(String addressZipcode) {
		waitForElementVisible(driver, userAddressesPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.ZIPCODE_TEXTBOX, addressZipcode);
	}

	@Step("Input to Phone number textbox with value is '" + "{0}'")
	public void inputToPhoneNumberTextbox(String addressPhoneNumber) {
		waitForElementVisible(driver, userAddressesPageUI.PHONE_NUMNER_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.PHONE_NUMNER_TEXTBOX, addressPhoneNumber);
	}

	@Step("Input to Fax number textbox with value is '" + "{0}'")
	public void inputToFaxNumberTextbox(String addressFaxNumber) {
		waitForElementVisible(driver, userAddressesPageUI.FAX_NUMNER_TEXTBOX);
		sendkeyToElement(driver, userAddressesPageUI.FAX_NUMNER_TEXTBOX, addressFaxNumber);
	}

	@Step("Click to Save button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, userAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, userAddressesPageUI.SAVE_BUTTON);
	}

	@Step("Verify Add address success message is displayed")
	public String getAddAddressSuccessMessage() {
		waitForElementVisible(driver, userAddressesPageUI.ADD_ADDRESS_SUCCESS_MESSAGE);
		return getElementText(driver, userAddressesPageUI.ADD_ADDRESS_SUCCESS_MESSAGE);
	}

	@Step("Verify First name and Last name is displayed")
	public String isFirstNameAndLastNameDisplayed() {
		waitForElementVisible(driver, userAddressesPageUI.FIRST_NAME_AND_LAST_NAME_INFO);
		return getElementText(driver, userAddressesPageUI.FIRST_NAME_AND_LAST_NAME_INFO);
	}

	@Step("Verify Email is displayed")
	public Boolean isEmailDisplayed(String email) {
		waitForElementVisible(driver, userAddressesPageUI.EMAIL_INFO);
		return isContainTextDisplayed(driver, userAddressesPageUI.EMAIL_INFO, email);
	}

	@Step("Verify Company name is displayed")
	public String isCompanyDisplayed() {
		waitForElementVisible(driver, userAddressesPageUI.COMPANY_INFO);
		return getElementText(driver, userAddressesPageUI.COMPANY_INFO);
	}

	@Step("Verify Country is displayed")
	public String isCountryDisplayed() {
		waitForElementVisible(driver, userAddressesPageUI.COUNTRY_INFO);
		return getElementText(driver, userAddressesPageUI.COUNTRY_INFO);
	}

	@Step("Verify City, State and Zip name is displayed")
	public String isCityStateZipDisplayed() {
		waitForElementVisible(driver, userAddressesPageUI.CITY_STATE_ZIP_INFO);
		return getElementText(driver, userAddressesPageUI.CITY_STATE_ZIP_INFO);
	}

	@Step("Verify Address1 is displayed")
	public String isAddress1Displayed() {
		waitForElementVisible(driver, userAddressesPageUI.ADDRESS1_INFO);
		return getElementText(driver, userAddressesPageUI.ADDRESS1_INFO);
	}

	@Step("Verify Address2 is displayed")
	public String isAddress2Displayed() {
		waitForElementVisible(driver, userAddressesPageUI.ADDRESS2_INFO);
		return getElementText(driver, userAddressesPageUI.ADDRESS2_INFO);
	}

	@Step("Verify Phone number is displayed")
	public boolean isPhoneNumberDisplayed(String phoneNumber) {
		waitForElementVisible(driver, userAddressesPageUI.PHONE_INFO);
		return isContainTextDisplayed(driver, userAddressesPageUI.PHONE_INFO, phoneNumber);
	}

	@Step("Verify Fax number is displayed")
	public boolean isFaxNumberDisplayed(String faxNumber) {
		waitForElementVisible(driver, userAddressesPageUI.FAX_INFO);
		return isContainTextDisplayed(driver, userAddressesPageUI.FAX_INFO, faxNumber);
	}
}
