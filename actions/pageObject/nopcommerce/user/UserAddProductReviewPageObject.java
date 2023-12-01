package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserAddProductReviewPageUI;

public class UserAddProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserAddProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input to Review title with value is '" + "{0}'")
	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, UserAddProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserAddProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	@Step("Input to Review text with value is '" + "{0}'")
	public void inputToReviewtextTextarea(String reviewText) {
		waitForElementVisible(driver, UserAddProductReviewPageUI.REVIEW_TEXT_TEXTAREA);
		sendkeyToElement(driver, UserAddProductReviewPageUI.REVIEW_TEXT_TEXTAREA, reviewText);
	}

	@Step("Select Rating radio button with rating is '" + "{0}' star")
	public void selectRatingRadioButton(String randomRating) {
		waitForElementClickable(driver, UserAddProductReviewPageUI.DYNAMIC_RATING_RADIO_BUTTON, randomRating);
		checkToDefaultCheckBoxRadio(driver, UserAddProductReviewPageUI.DYNAMIC_RATING_RADIO_BUTTON, randomRating);
	}

	@Step("Click to Submit Review button")
	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, UserAddProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserAddProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	@Step("Add new review product")
	public void addNewProductReview(String reviewTitle, String reviewText, String randomRating) {
		inputToReviewTitleTextbox(reviewTitle);
		inputToReviewtextTextarea(reviewText);
		selectRatingRadioButton(randomRating);
		clickToSubmitReviewButton();
	}
}
