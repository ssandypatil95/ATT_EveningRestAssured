package fetchdatafromresponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractComplexJsonData {

	

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
		
		int pathvalue = js.getInt("total");
		
		System.out.println(pathvalue);//12
		
	String urlvalue=	js.getString("support.url");
	
	System.out.println(urlvalue);//https://reqres.in/#support-heading
	
	String emailFirstIndex = js.getString("data[0].email");
	
	System.out.println(emailFirstIndex);//michael.lawson@reqres.in
	
	
//	WAP to fetch the value of firstname from all index positions
//	WAP to fetch the lastname of user whose email address is george.edwards@reqres.in
	
	
	
	
}
}
