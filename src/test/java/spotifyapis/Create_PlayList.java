package spotifyapis;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class Create_PlayList {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void reqResSpec() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

		requestSpecBuilder.setBaseUri("https://api.spotify.com/v1");

		requestSpecBuilder.setContentType(ContentType.JSON);

		requestSpecBuilder.addHeader("Authorization",
				"Bearer BQBtA0SHU1mPFxzSvFOIsg59mL_NBU3E2OZ4UQBxYtZLbCVpg9d2xDPLpyvKVdgVZbBs66u0EytLBhC9ak3sGXF-Vy3Gf9bkG7dc5kPusW_ER7rIj9I0vjK-JzujSOQba0DngKaLt4iO7CJrNniRyakmt36GLGHtAVFGqnbIyTR8ByGHMhNQ4UUYtLj7od-pHheCVqHg_8PF4T4KrgX0w8Niby3U0evGaqWGahP3QvJGzu8uH3WIwhVo2ODXT-VibLuEHIE1VavadIaa");

		requestSpecBuilder.log(LogDetail.ALL);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

		responseSpecBuilder.expectContentType(ContentType.JSON);
		responseSpecBuilder.log(LogDetail.ALL);

		responseSpecification = responseSpecBuilder.build();

	}
	
	
	@Test
	public void createPlaylist()
	{
		given(requestSpecification)
		
		.body("{\r\n"
				+ "    \"name\": \"Evening meshup\",\r\n"
				+ "    \"description\": \"Play list 2\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when()
		
		.post("users/31p6yxkpbqyn2ex2srl3rxb5n23i/playlists")
		
		.then()
		
		.spec(responseSpecification)
		
		.body("name", equalTo("Evening meshup"));
		
		
		
		
	}

}
