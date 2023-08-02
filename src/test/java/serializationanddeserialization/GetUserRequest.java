package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Data;
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
							
							.log().all()
		
							.extract()
		
							.response()
							
							.as(GetUserResponseBody.class);
		
		
		Integer totalpages = getUserSupportBody.getTotal_pages();
		
		System.out.println(totalpages);
		
//		fetching firstname from zeroth index position from Array in the json
		
		List<Data> listArray = getUserSupportBody.getData();
		
		Data zerothIndex = listArray.get(0);
		
		String zerothFirstname = zerothIndex.getFirst_name();
		
		System.out.println(zerothFirstname);
		
		
//		fetching all firstname from the Array:
		
		for(int i = 0; i<listArray.size(); i++)
		{
		String firstname = getUserSupportBody.getData().get(i).getFirst_name();
		System.out.println(firstname);
		}
		
		
		
}
}
