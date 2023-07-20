package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class FetchDataOfHeader {
	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
				
							.log().all()
		
							.when()
		
							.get("/api/users?page=2")
		
							.then()
		
							.extract()
		
							.response();
		
		Headers header = response.headers();
		
		String headervalue = header.toString();// this will return the complete header values
		
		System.out.println(headervalue);
		
		
//		fetching specific value of header
		
		
		String age = response.getHeader("Age");// this is will return the value of specific header key
		
		System.out.println(age);//5426
		
	
	}
	
	
	
	

}
