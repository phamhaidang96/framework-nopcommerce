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

	@Description("Sort product by Name ascending")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Sort_Name_Ascending() {
		userComputersPage.selectToSortByDropdownByOption("Name: A to Z");
		Assert.assertTrue(userComputersPage.isProductSortByNameAcsending());
	}

	@Description("Sort product by Name descending")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Sort_By_Name_Descending() {
		userComputersPage.selectToSortByDropdownByOption("Name: Z to A");
		Assert.assertTrue(userComputersPage.isProductSortByNameDescending());
	}

	@Description("Sort product by price ascending")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_Sort_By_Price_Ascending() {
		userComputersPage.selectToSortByDropdownByOption("Price: Low to High");
		Assert.assertTrue(userComputersPage.isProductSortByPriceAcsending());
	}

	@Description("Sort product by price descending")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_04_Sort_By_Price_Descending() {
		userComputersPage.selectToSortByDropdownByOption("Price: High to Low");
		Assert.assertTrue(userComputersPage.isProductSortByPriceDescending());
	}

	@Description("Display with 3 product per page")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_05_Display_3_Products_Per_Page() {
		userComputersPage.selectToDisplayPerPageDropdownByOption("3");
		Assert.assertTrue(userComputersPage.isDisplayThreeProductPerPage());
		Assert.assertTrue(userComputersPage.isNextPagingIconDisplay());

		userComputersPage.clickToNextPagingIcon();
		Assert.assertTrue(userComputersPage.isPreviousPagingIconDisplay());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
