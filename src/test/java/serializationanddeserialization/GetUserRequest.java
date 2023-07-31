package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.GetUserResponseBody;

public class GetUserRequest {
	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		GetUserResponseBody getUserSupportBody  = given()
		
							.when()
		
							.get("/api/users?page=2")
		
							.then()
		
							.extract()
		
							.response()
							
							.as(GetUserResponseBody.class);
		
		
		Integer totalpages = getUserSupportBody.getTotal_pages();
		
		System.out.println(totalpages);
}
}
