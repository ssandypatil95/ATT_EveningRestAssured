package sendingbodyasobject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ComplexPostCall {
	
	@Test
	public void postCall()
	{
		
//		creating body of the request
		
		HashMap<String, String> hm1 = new HashMap<String, String>();
		
		hm1.put("id", "1000");
		hm1.put("type", "grains");
		
		HashMap<String, String> hm2 = new HashMap<String, String>();
		
		hm2.put("id", "1001");
		hm2.put("type", "beverage");
		
		List<HashMap<String, String>> jsonObject = new ArrayList<HashMap<String,String>>();
		
		jsonObject.add(hm1);
		jsonObject.add(hm2);
		
		
		
		
		RestAssured.baseURI = "https://11373eed-b49b-48ff-ba24-d24fc6c83dc8.mock.pstmn.io";
		
		given()
		
		.header("x-mock-match-request-body", "true")
		
		.header("Content-Type", "application/json")
		
		.body(jsonObject)
		
		.log().all()
		
		.when()
		
		.post("/postcall")
		
		.then()
		
		.log().all();
		
	}

}
