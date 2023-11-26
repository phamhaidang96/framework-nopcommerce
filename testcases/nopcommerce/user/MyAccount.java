package nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import data.nopcommerce.user.UserRegisterDataMapper;
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

		userRegisterPage = userHomePage.openRegisterPage();
		userRegisterPage.RegisterNewAccount(firstName, lastName, email, password);
		userLoginPage = userHomePage.openToLoginPage();
		userHomePage = userLoginPage.LoginToSystem(email, password);
		userCustomerInfoPage = userHomePage.openCustomerInfoPage();
	}

	@Test
	public void TC_01_Update_Customer_Info() {
		userCustomerInfoPage.OpenPageAtMyAccountByName(driver, "Addresses");
		sleepInSecond(3);
	}

	@Test
	public void TC_02_Add_Address() {

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
