package assertionsfromrestassured;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class AssertionsUsage {
	
	@Test
	public void getAllWorkspaces()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
							.header("x-api-key", "api key")
		
							.when()
		
							.get("/workspaces")
		
							.then()
							
							.assertThat()
							
							.statusCode(200)
							
							.contentType(ContentType.JSON)
							
							.header("Connection", "keep-alive")
							
							.log().all()
		
							.extract()
			
							.response();
		
		
		
		
	}
	
	
	

}
