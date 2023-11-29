package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Select Gender with value is '" + "{0}'")
	public void selectGenderByText(String updateGender) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, updateGender);
		clickToElement(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, updateGender);
	}

	@Step("Input to Fisrt name textbox with value is '" + "{0}'")
	public void inputToFirstNameTextbox(String updatefirstName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, updatefirstName);
	}

	@Step("Input to Last name textbox with value is '" + "{0}'")
	public void inputToLastNameTextbox(String updateLastname) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, updateLastname);
	}

	@Step("Select Day of birth with value is '" + "{0}'")
	public void selectDayOfBirthDropdown(String dayOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DAY_OF_BIRTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DAY_OF_BIRTH_DROPDOWN, dayOfBirth);
	}

	@Step("Select Month of birth with value is '" + "{0}'")
	public void selectMonthOfBirthDropdown(String monthOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH_DROPDOWN, monthOfBirth);
	}

	@Step("Select Year of birth with value is '" + "{0}'")
	public void selectYearOfBirthDropdown(String yearOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH_DROPDOWN, yearOfBirth);
	}

	@Step("Input to Email textbox with value is '" + "{0}'")
	public void inputToEmailTextbox(String updateEmail) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, updateEmail);
	}

	@Step("Input to Company name textbox with value is '" + "{0}'")
	public void inputToCompanyNameTextbox(String updateCompanyName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, updateCompanyName);
	}

	@Step("Click to Save button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
	}

	@Step("Get update customer info success message")
	public String getCustomerInfoSuccessMessage() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.UPDATE_CUSTOMER_INFO_SUCCESS_MESSAGE);
		return getElementText(driver, UserCustomerInfoPageUI.UPDATE_CUSTOMER_INFO_SUCCESS_MESSAGE);
	}

	@Step("Verify Gender is updated with value is '" + "{0}'")
	public boolean isGenderUpdated(String genderText) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, genderText);
		return isElementSelected(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, genderText);
	}

	@Step("Verify First name is updated")
	public String getFirstNameUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	@Step("Verify Last name is updated")
	public String getLastNameUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	@Step("Verify Day of birth is updated")
	public String getDayOfBirthUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DAY_OF_BIRTH_DROPDOWN);
		return getSelectedItemInDefaultDropdownText(driver, UserCustomerInfoPageUI.DAY_OF_BIRTH_DROPDOWN);
	}

	@Step("Verify Month of birth is updated")
	public String getMonthOfBirtUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH_DROPDOWN);
		return getSelectedItemInDefaultDropdownText(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH_DROPDOWN);
	}

	@Step("Verify Year of birth is updated")
	public String getYearOfBirtUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH_DROPDOWN);
		return getSelectedItemInDefaultDropdownText(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH_DROPDOWN);
	}

	@Step("Verify Email is updated")
	public String getEmailUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	@Step("Verify Company name is updated")
	public String getCompanyNameUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
	}
}
