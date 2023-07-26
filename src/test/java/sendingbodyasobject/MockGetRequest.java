package sendingbodyasobject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class MockGetRequest {
	
	
	@Test
	public void getResponse()
	{
		RestAssured.baseURI = "https://11373eed-b49b-48ff-ba24-d24fc6c83dc8.mock.pstmn.io";
		
		given()
		
		.header("x-mock-response-code", "200")
		
		.log().all()
		
		.when()
		
		.get("/attgetcall")
		
		.then()
		
		.log().all();
		
	}

}
