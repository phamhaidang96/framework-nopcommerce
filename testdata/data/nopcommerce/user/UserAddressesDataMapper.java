package data.nopcommerce.user;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.GlobalConstants;

public class UserAddressesDataMapper {
	public static UserAddressesDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/userAddressesData.json"),
					UserAddressesDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("Address1")
	private Address1 address1;

	static class Address1 {
		@JsonProperty("firstName")
		private String firstName;

		@JsonProperty("lastName")
		private String lastName;

		@JsonProperty("email")
		private String email;

		@JsonProperty("company")
		private String company;

		@JsonProperty("country")
		private String country;

		@JsonProperty("state")
		private String state;

		@JsonProperty("city")
		private String city;

		@JsonProperty("address1")
		private String address1;

		@JsonProperty("address2")
		private String address2;

		@JsonProperty("zipcode")
		private String zipcode;

		@JsonProperty("phoneNumber")
		private String phoneNumber;

		@JsonProperty("faxNumber")
		private String faxNumber;
	}

	public String getFirstName() {
		return address1.firstName;
	}

	public String getLastName() {
		return address1.lastName;
	}

	public String getEmail() {
		return address1.email;
	}

	public String getCompany() {
		return address1.company;
	}

	public String getCountry() {
		return address1.country;
	}

	public String getState() {
		return address1.state;
	}

	public String getCity() {
		return address1.city;
	}

	public String getAddress1() {
		return address1.address1;
	}

	public String getAddress2() {
		return address1.address2;
	}

	public String getZipcode() {
		return address1.zipcode;
	}

	public String getPhoneNumber() {
		return address1.phoneNumber;
	}

	public String getFaxNumber() {
		return address1.faxNumber;
	}
}
