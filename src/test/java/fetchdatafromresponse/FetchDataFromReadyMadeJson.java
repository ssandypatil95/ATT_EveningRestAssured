package fetchdatafromresponse;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FetchDataFromReadyMadeJson {
	
	
	@Test
	public void fetchData()
	{
		String jsonbody = "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
		
		JsonPath jsonpath = new JsonPath(jsonbody);
		
	String website	= jsonpath.getString("dashboard.website");
	
	System.out.println(website);//www.abc.com
	
//	Assignment:
		
//	1. Print No of courses returned by API
//	2. Print Purchase Amount
//	3. Print Title of the first course
//	4. Print All course titles and their respective Prices
//	5. Print no of copies sold by RPA Course
//	6. Verify if Sum of all Course prices matches with Purchase Amount

	}

}
