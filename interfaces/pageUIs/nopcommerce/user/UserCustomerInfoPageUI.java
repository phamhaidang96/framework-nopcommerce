package pageUIs.nopcommerce.user;

public class UserCustomerInfoPageUI {
	public static final String DYNAMIC_GENDER_RADIO_BUTTON = "xpath=//div[@class='gender']//label[text()='%s']/preceding-sibling::input";
	public static final String FIRST_NAME_TEXTBOX = "css=input#FirstName";
	public static final String LAST_NAME_TEXTBOX = "css=input#LastName";
	public static final String DAY_OF_BIRTH_DROPDOWN = "css=select[name='DateOfBirthDay']";
	public static final String MONTH_OF_BIRTH_DROPDOWN = "css=select[name='DateOfBirthMonth']";
	public static final String YEAR_OF_BIRTH_DROPDOWN = "css=select[name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "css=input#Email";
	public static final String COMPANY_NAME_TEXTBOX = "css=input#Company";
	public static final String SAVE_BUTTON = "css=button#save-info-button";
	public static final String UPDATE_CUSTOMER_INFO_SUCCESS_MESSAGE = "css=div.bar-notification.success";
}
