package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateWorkspace {

	
	@Test
	public void createAWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
		.body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"ATT Evening batch updated RestAssured Workspace\",\r\n"
				+ "        \"type\": \"personal\",\r\n"
				+ "        \"description\": \"This workspace created using RestAssured Put code \"\r\n"
				+ "    }\r\n"
				+ "}")
		
		.header("x-api-key", "api key")
		
		.when()
		
		.put("/workspaces/a1599d53-ff0b-4246-87ba-df4cf1b66926")
		
		.then()
		
		.extract()
		
		.response();
		
		
	String stringresponse=	response.asPrettyString();
	
	System.out.println(stringresponse);
		
	}

}
