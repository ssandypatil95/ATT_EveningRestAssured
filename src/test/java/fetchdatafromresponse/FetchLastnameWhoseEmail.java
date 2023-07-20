package fetchdatafromresponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchLastnameWhoseEmail {
	

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
		
		for(int i=0; i<=5; i++)
		{
			String email = js.getString("data["+i+"].email");
			
			if(email.equals("george.edwards@reqres.in"))
			{
				String lastname = js.getString("data["+i+"].last_name");
				System.out.println(lastname);
			}
		
		}
		
		
	}

}
