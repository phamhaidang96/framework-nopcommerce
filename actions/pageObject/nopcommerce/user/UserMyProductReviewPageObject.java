package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Review title is displayed")
	public String getReviewTitle() {
		waitForAllElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TITLE);
	}

	@Step("Verify Review text is displayed")
	public String getReviewText() {
		waitForAllElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
	}

	@Step("Verify Rating is displayed")
	public String getReviewRating() {
		waitForAllElementVisible(driver, UserMyProductReviewPageUI.RATING);
		return getElementAttribute(driver, UserMyProductReviewPageUI.RATING, "style");
	}
}
