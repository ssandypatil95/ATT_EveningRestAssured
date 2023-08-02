package authschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BasicAuth {
	
	@Test
	public void executeGetEcho()
	{
		RestAssured.baseURI = "https://postman-echo.com";
		
		given()
		
		.header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
		
//		.auth()
//		
//		.basic("postman", "password")
		
		.log().all()
		
		.when()
		
		.get("/basic-auth")
		
		.then()
		
		.log().all();
	
	}

	
	
	
}
