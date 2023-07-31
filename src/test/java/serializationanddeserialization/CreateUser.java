package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.CreateUserRequestBody;
import pojo.CreateUserResponseBody;

public class CreateUser {
	
	@Test(priority = 1)
	public void createAnUser()
	{
		CreateUserRequestBody curb = new CreateUserRequestBody();
		
		curb.setId(0);
		curb.setUsername("ATTSerialization");
		curb.setFirstName("Serialization");
		curb.setLastName("Deserialization");
		curb.setEmail("att@att.com");
		curb.setPassword("Test@1234");
		curb.setPhone("9876543210");
		curb.setUserStatus(0);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
CreateUserResponseBody createUserResponse = given()
		
										.body(curb)
										.header("Content-Type", "application/json")
		
										.log().all()
		
										.when()
		
										.post("/user")
										
										.then()
		
										.log().all()
		
										.extract()
		
										.response()
		
										.as(CreateUserResponseBody.class);
		

		String messagevalue = createUserResponse.getMessage();
		
		System.out.println(messagevalue);
		
	}

}
