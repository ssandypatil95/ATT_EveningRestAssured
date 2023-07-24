package specbuilders;

import static io.restassured.RestAssured.given;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpecBuilder {
	RequestSpecification requestspecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void initReqAndResponseSpec()
	{
//		common properties for request 
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
		
		requestSpecBuilder.log(LogDetail.ALL);
		
		 requestspecification = requestSpecBuilder.build();
		
//		common properties for Response
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		responseSpecBuilder.expectStatusCode(200);
		
		responseSpecBuilder.expectContentType(ContentType.JSON);
		
		responseSpecBuilder.log(LogDetail.ALL);
		
	 responseSpecification = responseSpecBuilder.build();
		
		
		
	}
	
	
String messagevalue;
	
	@Test(priority = 1)
	public void createAnUser()
	{		
		Response response = given()
				
				.spec(requestspecification)
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"restassureduserlatest\",\r\n"
				+ "  \"firstName\": \"RestAssuredlatest\",\r\n"
				+ "  \"lastName\": \"User\",\r\n"
				+ "  \"email\": \"restassuredlatest.user@att.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543213\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		.header("Content-Type", "application/json")
				
		.when()
		
		.post("/user")
		
		.then()
		
		.spec(responseSpecification)
		
		.extract()
		
		.response();
		
		JsonPath jp = response.jsonPath();
		
		 messagevalue = jp.getString("message");
		
		System.out.println("Message value is "+messagevalue);
	}

	
	
	@Test(priority = 2)
	public void getUserDetails()
	{
		Response response = given()
				.spec(requestspecification)
		
		.pathParam("createdusername", "restassureduserlatest")
		
		.when()
		
		.get("/user/{createdusername}")
		
		.then()
		
		.spec(responseSpecification)
		
		.extract()
		
		.response();
		
	JsonPath jp = response.jsonPath();
	
	String idvalue= jp.getString("id");
	
	System.out.println("ID value is : "+idvalue);
		
	Assert.assertEquals(idvalue, messagevalue);
		
	}

}
