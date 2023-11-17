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

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentUrl) {
		ConfigFactory.setProperty("evn", environmentUrl);
		evnironment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(browserName, evnironment.url());

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "auto";
		lastName = "Test";
		emailRandom = "Autotest" + randNumber() + "@gmail.net";
		password = "Hai_dang1";
		invalidPassword = "12345";
	}

	@Description("Register with empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register_Empty_Data() {
		userRegisterPage = userHomePage.openRegisterPage();

		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Description("Register with invalid email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Register_Invalid_Email() {
		userRegisterPage = userHomePage.openRegisterPage();

		userRegisterPage.inputToFirstName(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(firstName);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Description("Register with password less than 6 charactor")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_Register_Password_Less_Than_6_Charactor() {
		userRegisterPage.refreshCurrentPage(driver);

		userRegisterPage.inputToFirstName(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailRandom);
		userRegisterPage.inputToPasswordTextbox(invalidPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(invalidPassword);
		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Description("Register with confirm password invalid")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_04_Register_Invalid_Confirm_Password() {
		userRegisterPage.refreshCurrentPage(driver);

		userRegisterPage.inputToFirstName(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailRandom);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(invalidPassword);
		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");
	}

	@Description("Register Successfully")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_05_Register_Successfully() {
		userRegisterPage.refreshCurrentPage(driver);

		userRegisterPage.inputToFirstName(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailRandom);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Description("Register with existing email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_06_Register_Existing_Email() {
		userRegisterPage = userHomePage.openRegisterPage();

		userRegisterPage.inputToFirstName(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailRandom);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getEmailExistingErrorMessage(), "The specified email already exists");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
