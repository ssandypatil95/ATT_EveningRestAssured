package sendingbodyasobject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SendingBodyUsingString {

	@Test(priority = 1)
	public void createAnUser() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
				given()

				.body(BodyCreator.getBody())
				
				.header("Content-Type", "application/json")

				.when()

				.post("/user")

				.then()

				.log().all();
	}

}
