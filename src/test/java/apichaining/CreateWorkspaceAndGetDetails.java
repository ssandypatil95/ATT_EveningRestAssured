package apichaining;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateWorkspaceAndGetDetails {

	String idvalue;
	@Test(priority = 1)
	public void createAWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
		.body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"API Chaining\",\r\n"
				+ "        \"type\": \"personal\",\r\n"
				+ "        \"description\": \"This workspace depicts API Chaining \"\r\n"
				+ "    }\r\n"
				+ "}")
		
		.header("x-api-key", "PMAK-64bfdf62e2502b002a2be44b-2a59f729f441780f5fc0db41ffe5b970f9")
		
		.log().all()
		
		.when()
		
		.post("/workspaces")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		JsonPath jp = response.jsonPath();
		
		 idvalue = jp.getString("workspace.id");
		 
		 System.out.println(idvalue);
	}
	
	@Test(priority = 2)
	public void getAWorkspaceDetail()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
							given()
		
							.header("x-api-key", "PMAK-64bfdf62e2502b002a2be44b-2a59f729f441780f5fc0db41ffe5b970f9")
							
							.pathParam("id", idvalue)
							
							.when()
		
							.get("/workspaces/{id}")
		
							.then()
		
							.assertThat()
							
							.body("workspace", hasEntry("id", idvalue));
		
		
		
		
	}
	
	
	
	

}
