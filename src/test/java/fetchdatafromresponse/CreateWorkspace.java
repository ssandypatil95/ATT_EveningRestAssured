package fetchdatafromresponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateWorkspace {
	@Test
	public void createAWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
		.body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"RestAssured Workspace2 to get data\",\r\n"
				+ "        \"type\": \"personal\",\r\n"
				+ "        \"description\": \"RestAssured \"\r\n"
				+ "    }\r\n"
				+ "}")
		
		.header("x-api-key", "api key")
		
		.when()
		
		.post("/workspaces")
		
		.then()
		
		.extract()
		
		.response();
		
		
	String stringresponse=	response.asPrettyString();
	
	System.out.println(stringresponse);
	
	JsonPath js = response.jsonPath();
	
	String idvalue = js.getString("workspace.id");
	
	System.out.println("Created workspace id is :"+idvalue);
	
	
		
	}

}
