package data.nopcommerce.user;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.GlobalConstants;

public class UserRegisterDataMapper {
	public static UserRegisterDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/userRegisterData.json"),
					UserRegisterDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("RegisterNewUser")
	private RegisterNewUser registerNewUser;

	static class RegisterNewUser {
		@JsonProperty("firstName")
		private String firstName;

		@JsonProperty("lastName")
		private String lastName;

		@JsonProperty("email")
		private String email;

		@JsonProperty("password")
		private String password;

		@JsonProperty("invalidPassword")
		private String invalidPassword;
	}

	public String getFirstName() {
		return registerNewUser.firstName;
	}

	public String getLastName() {
		return registerNewUser.lastName;
	}

	public String getEmail() {
		return registerNewUser.email;
	}

	public String getPassword() {
		return registerNewUser.password;
	}

	public String getInvalidPassword() {
		return registerNewUser.invalidPassword;
	}

	@JsonProperty("UpdateUser")
	private UpdateUser updateUser;

	static class UpdateUser {
		@JsonProperty("updateGender")
		private String updateGender;

		@JsonProperty("updateFirstName")
		private String updateFirstName;

		@JsonProperty("updatelastName")
		private String updatelastName;

		@JsonProperty("updateDayOfBirth")
		private String updateDayOfBirth;

		@JsonProperty("updateMonthOfBirth")
		private String updateMonthOfBirth;

		@JsonProperty("updateYearOfBirth")
		private String updateYearOfBirth;

		@JsonProperty("updateEmail")
		private String updateEmail;

		@JsonProperty("updateCompanyName")
		private String updateCompanyName;
	}

	public String getUpdateGender() {
		return updateUser.updateGender;
	}

	public String getUpdateFirstName() {
		return updateUser.updateFirstName;
	}

	public String getUpdatelastName() {
		return updateUser.updatelastName;
	}

	public String getUpdateDayOfBirth() {
		return updateUser.updateDayOfBirth;
	}

	public String getUpdateMonthOfBirth() {
		return updateUser.updateMonthOfBirth;
	}

	public String getUpdateYearOfBirth() {
		return updateUser.updateYearOfBirth;
	}

	public String getUpdateEmail() {
		return updateUser.updateEmail;
	}

	public String getUpdateCompanyName() {
		return updateUser.updateCompanyName;
	}
}
