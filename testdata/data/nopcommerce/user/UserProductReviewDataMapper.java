package data.nopcommerce.user;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.GlobalConstants;

public class UserProductReviewDataMapper {
	public static UserProductReviewDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/userAddProductReviewData.json"),
					UserProductReviewDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("ProductReview1")
	private ProductReview1 productReview1;

	static class ProductReview1 {
		@JsonProperty("reviewTitle")
		private String reviewTitle;

		@JsonProperty("reviewText")
		private String reviewText;
	}

	public String getReviewTitle() {
		return productReview1.reviewTitle;
	}

	public String getReviewText() {
		return productReview1.reviewText;
	}
}
