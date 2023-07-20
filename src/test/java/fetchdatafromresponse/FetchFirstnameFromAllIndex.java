package fetchdatafromresponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchFirstnameFromAllIndex {
	

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
		
		System.out.println(stringResponse);// complete json response
		
		
		JsonPath js = response.jsonPath();
		
		int numberofelements = js.getInt("data.size()");
		
		System.out.println("Total number of elements present are: "+numberofelements);
		
		for(int i=0; i<=5; i++)
		{
			String firstname = js.getString("data["+i+"].first_name");
			
			System.out.println(firstname);
		
		}
		
		
	}

}
