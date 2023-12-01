package common;

import org.openqa.selenium.WebDriver;

import pageObject.nopcommerce.user.UserAddProductReviewPageObject;
import pageObject.nopcommerce.user.UserAddressesPageObject;
import pageObject.nopcommerce.user.UserChangePasswordPageObject;
import pageObject.nopcommerce.user.UserComputersPageObject;
import pageObject.nopcommerce.user.UserCustomerInfoPageObject;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserLoginPageObject;
import pageObject.nopcommerce.user.UserMyProductReviewPageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserComputersPageObject getUserComputersPage(WebDriver driver) {
		return new UserComputersPageObject(driver);
	}

	public static UserAddProductReviewPageObject getUserAddYourReviewPage(WebDriver driver) {
		return new UserAddProductReviewPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
}
