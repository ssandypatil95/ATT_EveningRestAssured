package authschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BearerToken {
	
	
	@Test
	public void getRepository()
	{
		RestAssured.baseURI = "https://api.github.com";
		
		
		given()
		
		.header("Accept", "application/vnd.github+json")
		
		.header("Authorization", "Bearer token_value")
		
		.header("X-GitHub-Api-Version", "2022-11-28")
		
		.log().all()
		
		.when()
		
		.get("/user/repos")
		
		.then()
		
		.log().all();
		
		
		
	}
	
	

}
