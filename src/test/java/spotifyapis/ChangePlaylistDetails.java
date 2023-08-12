package spotifyapis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class ChangePlaylistDetails {
	
	
	@Test
	public void updatePlayList()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1";
		
		given()
		
		.headers("Authorization", "Bearer BQCSvBTA9ze_X5d4elurgzwewMRtE4v63FgHIj9TtTogrCBKTUHV0gYfmeoEatg9iIYi355u8kXqZ4MYrP8P_2dL7xKo9K1SG9mHicB1-Epv7QjxNA30ldKSn9j7XYqQEqyu4uop5g38PAbRm85MwA7V9mz24FMSf-XzU7iijNEYJx1yFmLD5CyXPHH_kRpyBbsmOvmgWb2j1Dqs_ph3IlrHBRKnuCGaya61GcBnnRW6uOV6wdSBfr4RMVxJeQbGxic6v3k0sd6kA2Em")
	
		.headers("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "    \"name\": \"Morning meshup updated playlist\",\r\n"
				+ "    \"description\": \"This test represents the updation of morning meshup\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.pathParam("playlistId", "1vvsgXhFuHSYCCwySumWRM")
		
		.when()
		
		.put("playlists/{playlistId}")
		
		.then()
		
		.assertThat()
		
		.statusCode(200);
		
		
		
		
	
	
	}

}
