package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAWorkspaceDetails {
	

	@Test
	public void getAWorkspaceDetail()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
							.header("x-api-key", "api key")
		
							.when()
		
							.get("/workspaces/bd441a1d-7648-410c-85d4-04617fc22b1c")
		
							.then()
		
							.extract()
			
							.response();
		
		String resp = response.asPrettyString();
		
		System.out.println(resp);
		
		
	}

}
