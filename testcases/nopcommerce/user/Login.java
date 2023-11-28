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
import pageObject.nopcommerce.user.UserLoginPageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;
import utilities.Environment;

public class Login extends BaseTest {
	private WebDriver driver;
	private Environment environment;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserRegisterDataMapper userRegisterData;
	private String emailRandom, password, invalidEmail, incorrectPassword, notRegisterEmail;
	private String firstName, lastName;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentUrl) {
		ConfigFactory.setProperty("evn", environmentUrl);
		environment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(browserName, environment.url());
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userRegisterData = UserRegisterDataMapper.getUserData();
		firstName = userRegisterData.getFirstName();
		lastName = userRegisterData.getLastName();
		emailRandom = userRegisterData.getEmail() + randNumber() + "@gmail.net";
		password = userRegisterData.getPassword();
		invalidEmail = userRegisterData.getLastName();
		incorrectPassword = password + randNumber();
		notRegisterEmail = userRegisterData.getEmail() + randNumber() + "@gmail.com";

		userRegisterPage = userHomePage.openRegisterPage();
		userRegisterPage.RegisterNewAccount(firstName, lastName, emailRandom, password);
		userLoginPage = userHomePage.openToLoginPage();
	}

	@Description("Login with empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Login_Empty_Data() {
		userLoginPage.clickToLoginButton();

		Assert.assertEquals(userLoginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Description("Login with invalid Email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Login_Invalid_Email() {
		userLoginPage = userHomePage.openToLoginPage();

		userLoginPage.inputToEmailTextbox(invalidEmail);
		userLoginPage.clickToLoginButton();

		Assert.assertEquals(userLoginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Description("Login with email not register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_Login_Email_Not_Register() {
		userLoginPage = userHomePage.openToLoginPage();

		userLoginPage.inputToEmailTextbox(notRegisterEmail);
		userLoginPage.clickToLoginButton();

		Assert.assertEquals(userLoginPage.getLoginUnsuccessfulErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Description("Login with registered email and do not input password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_04_Login_Registered_Email_And_Do_Not_Input_Passwod() {
		userLoginPage = userHomePage.openToLoginPage();

		userLoginPage.inputToEmailTextbox(emailRandom);
		userLoginPage.clickToLoginButton();

		Assert.assertEquals(userLoginPage.getLoginUnsuccessfulErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Description("Login with registered email and incorrect password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_05_Login_Registered_Email_And_Incorrect_Passwod() {
		userLoginPage = userHomePage.openToLoginPage();

		userLoginPage.inputToEmailTextbox(emailRandom);
		userLoginPage.inputToPasswordTextbox(incorrectPassword);
		userLoginPage.clickToLoginButton();

		Assert.assertEquals(userLoginPage.getLoginUnsuccessfulErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Description("Login successful")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_06_Login_Successful() {
		userLoginPage = userHomePage.openToLoginPage();

		userLoginPage.inputToEmailTextbox(emailRandom);
		userLoginPage.inputToPasswordTextbox(password);
		userLoginPage.clickToLoginButton();

		Assert.assertTrue(userLoginPage.isMyAccountLinkDisplay());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
