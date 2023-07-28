package sendingbodyasobject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostComplexJson {
	
	// creating the body of the complex json as per the requirement
	
	
	@Test
	public void sendingComplexJson()
	{
		
//		defining the inner most array which is the value of id
		
		List<Integer> arrayOfId = new ArrayList<Integer>();
		
		arrayOfId.add(5);
		arrayOfId.add(9);
		
//	 batter's hashmap creation
		
		HashMap<String, Object> batterHashMap1 =  new HashMap<String, Object>();
		batterHashMap1.put("id", "1001");
		batterHashMap1.put("type", "Regular");
		
		HashMap<String, Object> batterHashMap2 = new HashMap<String, Object>();
		
		batterHashMap2.put("id", arrayOfId);
		batterHashMap2.put("type", "Chocolate");
		
//		Defining the batter's array
		
		List<HashMap<String, Object>> batterArrayList = new ArrayList<HashMap<String,Object>>();
		
		batterArrayList.add(batterHashMap1);
		batterArrayList.add(batterHashMap2);
		
//		Defining the batters hashmap
		
		HashMap<String, List<HashMap<String, Object>>> battersHashMap = new HashMap<String, List<HashMap<String,Object>>>();
		
		battersHashMap.put("batter", batterArrayList);
		
		
//	defining toppings
		
//		first topping hashmap
		
		HashMap<String, String> topping1 = new HashMap<String, String>();
		topping1.put("id", "5001");
		
		topping1.put("type", "None");

//		second topping hashmap
		HashMap<String, String> topping2 = new HashMap<String, String>();
		topping2.put("id", "5002");
		
		topping2.put("type", "Glazed");
		
		
//		third topping hashmap
		HashMap<String, String> topping3 = new HashMap<String, String>();
		topping3.put("id", "5005");
		
		topping3.put("type", "Sugar");
		
		List<HashMap<String, String>> toppingValue = new ArrayList<HashMap<String,String>>();
		
		toppingValue.add(topping1);
		toppingValue.add(topping2);
		toppingValue.add(topping3);
		
		
		HashMap<String, Object> mainJsonObject = new HashMap<String, Object>();
		
		mainJsonObject.put("id", "0001");
		mainJsonObject.put("type", "donut");
		mainJsonObject.put("name", "Cake");
		mainJsonObject.put("ppu", 0.55);
		mainJsonObject.put("batters", battersHashMap);
		mainJsonObject.put("topping", toppingValue);
		
		
		RestAssured.baseURI = "https://11373eed-b49b-48ff-ba24-d24fc6c83dc8.mock.pstmn.io";
		
		given()
		
		.header("Content-Type", "application/json")
		
		.header("x-mock-match-request-body", "true")
		
		.body(mainJsonObject)
		
		.log().all()
		
		.when()
		
		.post("/postcomplexjson")
		
		.then()
		
		.log().all();
		
		
		
		
		
		
		
		
	}

}
