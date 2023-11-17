package nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;
import utilities.Environment;

public class Register extends BaseTest {
	private WebDriver driver;
	private Environment evnironment;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentUrl) {
		ConfigFactory.setProperty("evn", environmentUrl);
		evnironment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(browserName, evnironment.url());

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userRegisterPage = userHomePage.openRegisterPage();
		sleepInSecond(3);
	}

	@Test
	public void TC_01_Register_Empty_Data() {

	}

	@Test
	public void TC_02_Register_Invalid_Email() {

	}

	@Test
	public void TC_03_Register_Existing_Email() {

	}

	@Test
	public void TC_04_Register_Password_Less_Than_6_Charactor() {

	}

	@Test
	public void TC_05_Register_Invalid_Confirm_Passwor() {

	}

	@Test
	public void TC_0_Register_Successfully() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
