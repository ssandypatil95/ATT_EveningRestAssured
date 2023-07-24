package assertionsfromrestassured;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class AssertionsUsage {
	
	@Test
	public void getAllWorkspaces()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
							given()
		
							.header("x-api-key", "PMAK-64ba98e472efea0042e0d58f-0cfa5114cafd0db13eb718a09f04be5a4e")
		
							.when()
		
							.get("/workspaces")
		
							.then()
							
							.assertThat()
							
							.statusCode(200)
							
							.contentType(ContentType.JSON)
							
							.header("Connection", "keep-alive")
							
							.log().all()
		
							.body("workspaces[1]", hasKey("id"))// verifying whether array has an element id
							
							.body("workspaces.name", contains( "Team Workspace", "My Workspace", "My Workspace", "ATTWorkspace", "TestWorkspace", "Test Workspace", "ATTObjectWorkspace", "Manual Workspace", "ATT Evening batch Workspace2", "RestAssured Workspace to get data"))
				// above line validates whether the name has all the possible values in a specific sequence using contains method
							
							.body("workspaces.name", containsInAnyOrder("Manual Workspace","Team Workspace", "My Workspace", "My Workspace", "ATTWorkspace", "TestWorkspace", "Test Workspace", "ATTObjectWorkspace",  "ATT Evening batch Workspace2", "RestAssured Workspace to get data"))
							
//		above method validates whether the name of all the workspaces are present into the body but does't matter whether they are in the specific sequence or not
							
							.body("workspaces.name", hasItem("ATTWorkspace"))
//		above method validates whether name has one of the values --> 	ATTWorkspace
							
							.body("workspaces[1]", hasEntry("type", "team"))
//		above method validates whether workspace 1 index has an entry(key value pair) 					
							.body("workspaces[1].name", equalToIgnoringCase("My WorkSpace"))
//				above method validates whether the data is matching with the response by ignoring the case
							.body("workspaces.name", hasItems("ATTWorkspace","Manual Workspace" ));
							
						
	}
	
	
	

}
