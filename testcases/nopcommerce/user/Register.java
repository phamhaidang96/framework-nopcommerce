package nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;

public class Register extends BaseTest {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		getBroserDriver("chrome");
		sleepInSecond(2);
	}

	@Test
	public void TC_01() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
