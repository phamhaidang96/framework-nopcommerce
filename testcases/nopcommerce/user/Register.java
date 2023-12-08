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
import data.nopcommerce.user.UserRegisterDataMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;
import utilities.Environment;

public class Register extends BaseTest {
	private WebDriver driver;
	private Environment evnironment;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private String firstName, lastName, emailRandom, password, invalidPassword;
	private UserRegisterDataMapper userRegisterData;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentUrl) {
		ConfigFactory.setProperty("evn", environmentUrl);
		evnironment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(browserName, evnironment.url());
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userRegisterData = UserRegisterDataMapper.getUserData();
		firstName = userRegisterData.getFirstName();
		lastName = userRegisterData.getLastName();
		emailRandom = userRegisterData.getEmail() + randNumber() + "@gmail.net";
		password = userRegisterData.getPassword();
		invalidPassword = userRegisterData.getInvalidPassword();
	}

	@Description("Register with empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register_Empty_Data() {
		userRegisterPage = userHomePage.openRegisterPage();

		userRegisterPage.clickToRegisterButton();

		verifyEquals(userRegisterPage.getErrorMessageAtFirstNameTextbox(), "First name is required..");
		verifyEquals(userRegisterPage.getErrorMessageAtLastNameTextbox(), "Last name is required..");
		verifyEquals(userRegisterPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		verifyEquals(userRegisterPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required..");
	}

//	@Description("Register with invalid email")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		userRegisterPage = userHomePage.openRegisterPage();
//
//		userRegisterPage.inputToFirstNameTextbox(firstName);
//		userRegisterPage.inputToLastNameTextbox(lastName);
//		userRegisterPage.inputToEmailTextbox(firstName);
//		userRegisterPage.inputToPasswordTextbox(password);
//		userRegisterPage.inputToConfirmPasswordTextbox(password);
//		userRegisterPage.clickToRegisterButton();
//
//		Assert.assertEquals(userRegisterPage.getErrorMessageAtEmailTextbox(), "Wrong email");
//	}
//
//	@Description("Register with password less than 6 charactor")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_03_Register_Password_Less_Than_6_Charactor() {
//		userRegisterPage.refreshCurrentPage(driver);
//
//		userRegisterPage.inputToFirstNameTextbox(firstName);
//		userRegisterPage.inputToLastNameTextbox(lastName);
//		userRegisterPage.inputToEmailTextbox(emailRandom);
//		userRegisterPage.inputToPasswordTextbox(invalidPassword);
//		userRegisterPage.inputToConfirmPasswordTextbox(invalidPassword);
//		userRegisterPage.clickToRegisterButton();
//
//		Assert.assertEquals(userRegisterPage.getErrorMessageAtPasswordTextbox(),
//				"Password must meet the following rules:\nmust have at least 6 characters");
//	}
//
//	@Description("Register with confirm password invalid")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_04_Register_Invalid_Confirm_Password() {
//		userRegisterPage.refreshCurrentPage(driver);
//
//		userRegisterPage.inputToFirstNameTextbox(firstName);
//		userRegisterPage.inputToLastNameTextbox(lastName);
//		userRegisterPage.inputToEmailTextbox(emailRandom);
//		userRegisterPage.inputToPasswordTextbox(password);
//		userRegisterPage.inputToConfirmPasswordTextbox(invalidPassword);
//		userRegisterPage.clickToRegisterButton();
//
//		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox(),
//				"The password and confirmation password do not match.");
//	}
//
//	@Description("Register Successfully")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_05_Register_Successfully() {
//		userRegisterPage.refreshCurrentPage(driver);
//
//		userRegisterPage.inputToFirstNameTextbox(firstName);
//		userRegisterPage.inputToLastNameTextbox(lastName);
//		userRegisterPage.inputToEmailTextbox(emailRandom);
//		userRegisterPage.inputToPasswordTextbox(password);
//		userRegisterPage.inputToConfirmPasswordTextbox(password);
//		userRegisterPage.clickToRegisterButton();
//
//		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
//	}
//
//	@Description("Register with existing email")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_06_Register_Existing_Email() {
//		userRegisterPage = userHomePage.openRegisterPage();
//
//		userRegisterPage.inputToFirstNameTextbox(firstName);
//		userRegisterPage.inputToLastNameTextbox(lastName);
//		userRegisterPage.inputToEmailTextbox(emailRandom);
//		userRegisterPage.inputToPasswordTextbox(password);
//		userRegisterPage.inputToConfirmPasswordTextbox(password);
//		userRegisterPage.clickToRegisterButton();
//
//		Assert.assertEquals(userRegisterPage.getEmailExistingErrorMessage(), "The specified email already exists");
//	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
