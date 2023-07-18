package basiccalls;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_UserDetails {
	
	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
		
							.when()
		
							.get("/api/users?page=2")
		
							.then()
		
							.extract()
		
							.response();
		
		
		String stringResponse = response.asPrettyString();
		
		System.out.println(stringResponse);
		
		int statusCode = response.statusCode();//status code received in the response
		
		System.out.println(statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		long timevalue = response.getTime();
		
		System.out.println(timevalue);
		
		
		
			
	}

}
