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
import pageObject.nopcommerce.user.UserComputersPageObject;
import pageObject.nopcommerce.user.UserHomePageObject;
import utilities.Environment;

public class SortDisplayPaging extends BaseTest {
	private WebDriver driver;
	private Environment evn;
	private UserHomePageObject userHomePage;
	private UserComputersPageObject userComputersPage;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environment) {
		ConfigFactory.setProperty("evn", environment);
		evn = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(browserName, evn.url());

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userComputersPage = (UserComputersPageObject) userHomePage.openProductAtHeaderMenuByName(driver, "Computers");
		userComputersPage.openPageAtMenuComputersSublistByName("Notebooks");
	}

	@Description("Sort by Name: A - Z")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Sort_Name_A_Z() {
		userComputersPage.selectToSortByDropdownByOption("Name: A to Z");
		Assert.assertTrue(userComputersPage.isProductSortByNameAcsending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
