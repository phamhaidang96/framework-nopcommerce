package nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import data.nopcommerce.user.UserAddressesDataMapper;
import data.nopcommerce.user.UserRegisterDataMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopcommerce.user.UserAddressesPageObject;
import pageObject.nopcommerce.user.UserCustomerInfoPageObject;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserLoginPageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;
import utilities.Environment;

public class MyAccount extends BaseTest {
	private WebDriver driver;
	private Environment evn;
	private UserRegisterDataMapper userRegisterData;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private String firstName, lastName, email, password;
	private String updateGender, updatefirstName, updateLastname, dayOfBirth, monthOfBirth, yearOfBirth, updateEmail,
			updateCompanyName;
	private UserAddressesPageObject userAddressesPage;
	private UserAddressesDataMapper userAddressesData;
	private String addressFisrtName, addressLastName, addressEmail, addressCompany, addressCountry, addressState,
			addressCity, address1, address2, addressZipcode, addressPhoneNumber, addressFaxNumber;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String envUrl) {
		ConfigFactory.setProperty("evn", envUrl);
		evn = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(browserName, evn.url());

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userRegisterData = UserRegisterDataMapper.getUserData();

		firstName = userRegisterData.getFirstName();
		lastName = userRegisterData.getLastName();
		email = userRegisterData.getEmail() + randNumber() + "@gmail.net";
		password = userRegisterData.getPassword();

		updateGender = userRegisterData.getUpdateGender();
		updatefirstName = userRegisterData.getUpdateFirstName();
		updateLastname = userRegisterData.getUpdatelastName();
		dayOfBirth = userRegisterData.getUpdateDayOfBirth();
		monthOfBirth = userRegisterData.getUpdateMonthOfBirth();
		yearOfBirth = userRegisterData.getUpdateYearOfBirth();
		updateEmail = userRegisterData.getUpdateEmail() + randNumber() + "@gmail.net";
		updateCompanyName = userRegisterData.getUpdateCompanyName();

		userRegisterPage = userHomePage.openRegisterPage();
		userRegisterPage.RegisterNewAccount(firstName, lastName, email, password);
		userLoginPage = userHomePage.openToLoginPage();
		userHomePage = userLoginPage.LoginToSystem(email, password);
		userCustomerInfoPage = userHomePage.openCustomerInfoPage();

		userAddressesData = UserAddressesDataMapper.getUserData();
		addressFisrtName = userAddressesData.getFirstName();
		addressLastName = userAddressesData.getLastName();
		addressEmail = userAddressesData.getEmail() + randNumber() + "@gmail.net";
		addressCompany = userAddressesData.getCompany();
		addressCountry = userAddressesData.getCountry();
		addressState = userAddressesData.getState();
		addressCity = userAddressesData.getCity();
		address1 = userAddressesData.getAddress1();
		address2 = userAddressesData.getAddress2();
		addressZipcode = userAddressesData.getZipcode();
		addressPhoneNumber = userAddressesData.getPhoneNumber();
		addressFaxNumber = userAddressesData.getFaxNumber();
	}

	@Description("Update customer info")
	@Severity(SeverityLevel.NORMAL)
	public void TC_01_Update_Customer_Info() {
		userCustomerInfoPage.selectGenderByText(updateGender);
		userCustomerInfoPage.inputToFirstNameTextbox(updatefirstName);
		userCustomerInfoPage.inputToLastNameTextbox(updateLastname);
		userCustomerInfoPage.selectDayOfBirthDropdown(dayOfBirth);
		userCustomerInfoPage.selectMonthOfBirthDropdown(monthOfBirth);
		userCustomerInfoPage.selectYearOfBirthDropdown(yearOfBirth);
		userCustomerInfoPage.inputToEmailTextbox(updateEmail);
		userCustomerInfoPage.inputToCompanyNameTextbox(updateCompanyName);
		userCustomerInfoPage.clickToSaveButton();

		Assert.assertEquals(userCustomerInfoPage.getCustomerInfoSuccessMessage(),
				"The customer info has been updated successfully.");
		Assert.assertTrue(userCustomerInfoPage.isGenderUpdated(updateGender));
		Assert.assertEquals(userCustomerInfoPage.getFirstNameUpdated(), updatefirstName);
		Assert.assertEquals(userCustomerInfoPage.getLastNameUpdated(), updateLastname);
		Assert.assertEquals(userCustomerInfoPage.getDayOfBirthUpdated(), dayOfBirth);
		Assert.assertEquals(userCustomerInfoPage.getMonthOfBirtUpdated(), monthOfBirth);
		Assert.assertEquals(userCustomerInfoPage.getYearOfBirtUpdated(), yearOfBirth);
		Assert.assertEquals(userCustomerInfoPage.getEmailUpdated(), updateEmail);
		Assert.assertEquals(userCustomerInfoPage.getCompanyNameUpdated(), updateCompanyName);
	}

	@Description("Add new address for customer")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Add_Address() {
		userCustomerInfoPage.OpenPageAtMyAccountByName(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driver);

		userAddressesPage.clickToAddNewButton();
		userAddressesPage.inputToFirstNameTextbox(addressFisrtName);
		userAddressesPage.inputToLastNameTextbox(addressLastName);
		userAddressesPage.inputToEmailTextbox(addressEmail);
		userAddressesPage.inputToCompanyTextbox(addressCompany);
		userAddressesPage.selectCountryDropdown(addressCountry);
		userAddressesPage.selectStateDropdown(addressState);
		userAddressesPage.inputToCityTextbox(addressCity);
		userAddressesPage.inputToAddress1Textbox(address1);
		userAddressesPage.inputToAddress2Textbox(address2);
		userAddressesPage.inputToZipcodeTextbox(addressZipcode);
		userAddressesPage.inputToPhoneNumberTextbox(addressPhoneNumber);
		userAddressesPage.inputToFaxNumberTextbox(addressFaxNumber);
		userAddressesPage.clickToSaveButton();

		Assert.assertEquals(userAddressesPage.getAddAddressSuccessMessage(),
				"The new address has been added successfully.");
		Assert.assertEquals(userAddressesPage.isFirstNameAndLastNameDisplayed(),
				addressFisrtName + " " + addressLastName);
		Assert.assertTrue(userAddressesPage.isEmailDisplayed(addressEmail));
		Assert.assertEquals(userAddressesPage.isCompanyDisplayed(), addressCompany);
		Assert.assertEquals(userAddressesPage.isCountryDisplayed(), addressCountry);
		Assert.assertEquals(userAddressesPage.isCityStateZipDisplayed(),
				addressCity + ", " + addressState + ", " + addressZipcode);
		Assert.assertEquals(userAddressesPage.isAddress1Displayed(), address1);
		Assert.assertEquals(userAddressesPage.isAddress2Displayed(), address2);
		Assert.assertTrue(userAddressesPage.isPhoneNumberDisplayed(addressPhoneNumber));
		Assert.assertTrue(userAddressesPage.isFaxNumberDisplayed(addressFaxNumber));
	}

	@Test
	public void TC_03_Changer_Password() {

	}

	@Test
	public void TC_04_Add_Product_review() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
