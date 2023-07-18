package basiccalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetPostManWorkspace {
	
	
	@Test
	public void getAllWorkspaces()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
							.header("x-api-key", "api key")
		
							.when()
		
							.get("/workspaces")
		
							.then()
		
							.extract()
			
							.response();
		
		String resp = response.asPrettyString();
		
		System.out.println(resp);
		
		
	}

}
