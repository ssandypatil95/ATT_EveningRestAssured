package spotifyapis;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class NegativeScenarios {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void reqResSpec() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

		requestSpecBuilder.setBaseUri("https://api.spotify.com/v1");

		requestSpecBuilder.setContentType(ContentType.JSON);

		requestSpecBuilder.addHeader("Authorization",
				"Bearer BQDh_VKeDCGNvWLVvN5tg6v65CXTySbNJVf9NiVMxba7Ft4ZP8pUZeEPYCaNfLdrlqlqAy0FiMv-vSqdSRNzugs1F7b641QwpqvfKB0DsGnyI1ZLFKRBBHdqMjTrj9MmWpvYp2ZJM1bhb0LYoSs_DdnCmNGuvFMda0lA5m6MuIDf02WQT2L8FMVP7uZy-TMmjSjnujseag1Rucg3G1mWIqZaXvM62KkX5o89hq9o1szb3pk74H9l1UM-Jx7uvvrls5xrlmxhd-on_QvN");

		requestSpecBuilder.log(LogDetail.ALL);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

		responseSpecBuilder.expectContentType(ContentType.JSON);
		responseSpecBuilder.log(LogDetail.ALL);

		responseSpecification = responseSpecBuilder.build();

	}
	
	
	@Test(priority = 1)
	public void shouldNotBeAbleToCreatePlayList()
	{
		given()
		
		.spec(requestSpecification)
		
		.body("{\r\n"
				+ "    \"name\": \"\",\r\n"
				+ "    \"description\": \"Test playlist for ATT evening\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		.when()
		
		.post("users/31p6yxkpbqyn2ex2srl3rxb5n23i/playlists")
		
		.then()
		
		.spec(responseSpecification)
		
		.assertThat()
		
		.statusCode(400);
				
	}
	
	
	@Test(priority = 2)
	public void shouldNotBeAuthorized()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1";
				
		given()
		
		.headers("Authorization",
				"Bearer kshfkhkjfhksdhfkshdkfsdfhjsdhfkjsfhkjsdfhkjsd")
		.headers("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "    \"name\": \"Test create playlist\",\r\n"
				+ "    \"description\": \"Test playlist for ATT evening\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		.when()
		
		.post("users/31p6yxkpbqyn2ex2srl3rxb5n23i/playlists")
		
		.then()
		
		.spec(responseSpecification)
		
		.assertThat()
		
		.statusCode(401);
				
	}

}
