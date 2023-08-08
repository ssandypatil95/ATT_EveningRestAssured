package spotifyapis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Get_User_Profiles {
	
	@Test
	public void getUserID()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1";
		
		given()
		
		.header("Authorization", "Bearer BQBtA0SHU1mPFxzSvFOIsg59mL_NBU3E2OZ4UQBxYtZLbCVpg9d2xDPLpyvKVdgVZbBs66u0EytLBhC9ak3sGXF-Vy3Gf9bkG7dc5kPusW_ER7rIj9I0vjK-JzujSOQba0DngKaLt4iO7CJrNniRyakmt36GLGHtAVFGqnbIyTR8ByGHMhNQ4UUYtLj7od-pHheCVqHg_8PF4T4KrgX0w8Niby3U0evGaqWGahP3QvJGzu8uH3WIwhVo2ODXT-VibLuEHIE1VavadIaa")
		
		.when()
		
		.get("/me")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}

}
