package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCall {
	@Test
	public void deleteAWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
		.header("x-api-key", "api key")
		
		.when()	
		
		.delete("/workspaces/a1599d53-ff0b-4246-87ba-df4cf1b66926")
		
		.then()
		
		.extract()
		
		.response();
		
		
	String stringresponse=	response.asPrettyString();
	
	System.out.println(stringresponse);
		
	}


}
