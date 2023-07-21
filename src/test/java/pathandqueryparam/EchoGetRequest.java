package pathandqueryparam;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class EchoGetRequest {
	
	
	@Test
	public void getEchoParam()
	{
		
		HashMap<String, String> qp = new HashMap<String, String>();
		
		qp.put("foo1", "bar1");
		qp.put("foo2", "bar2");
		qp.put("foo3", "bar3");
		qp.put("foo4", "bar4");


		RestAssured.baseURI = "https://postman-echo.com";
		
		given()
		
		.queryParams(qp)
		
//		.queryParams("foo1","bar1", "foo2", "bar2")
		
		.header("x-api-key", "PMAK-64ba98e472efea0042e0d58f-0cfa5114cafd0db13eb718a09f04be5a4e")
		
		.log().all()
		.when()
		
		.get("/get")
		
		.then()
		
		.log().all();
	
	
		
		
		
	}

}
