package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeadCall {
	@Test
	public void getAllWorkspaces()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
						Response resp = given()
		
							.header("x-api-key", "api- key")
		
							.when()
		
							.head("/workspaces")
		
							.then()
		
							.extract()
			
							.response();
						
						int statuscode = resp.statusCode();
						
						
						System.out.println(statuscode);
		
							
							
	
		
		
	}


}
