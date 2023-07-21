package pathandqueryparam;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryParameters {
	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
							given()
							
							.queryParam("page", "2")
							
							.queryParam("line", "6")
							
							.log().all()
		
							.when()
		
							.get("/api/users")
		
							.then()
							
							.log().all()
		
							.extract()
		
							.response();
		
	}
		

}
