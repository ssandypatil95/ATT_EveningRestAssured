package spotifyapis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import io.restassured.RestAssured;

public class CreatePlaylist_WithPojo {
	

	@Test
	public void createPlaylist()
	{
		Playlist reqPlaylist  = new Playlist();
		
		reqPlaylist.setName("Playlist test using pojo");
		reqPlaylist.setDescription("Using pojo class to create the playlist");
		reqPlaylist.setPublic(false);
		
		
		RestAssured.baseURI = "https://api.spotify.com/v1";
		
		given()
		
		.headers("Authorization", "Bearer BQCSvBTA9ze_X5d4elurgzwewMRtE4v63FgHIj9TtTogrCBKTUHV0gYfmeoEatg9iIYi355u8kXqZ4MYrP8P_2dL7xKo9K1SG9mHicB1-Epv7QjxNA30ldKSn9j7XYqQEqyu4uop5g38PAbRm85MwA7V9mz24FMSf-XzU7iijNEYJx1yFmLD5CyXPHH_kRpyBbsmOvmgWb2j1Dqs_ph3IlrHBRKnuCGaya61GcBnnRW6uOV6wdSBfr4RMVxJeQbGxic6v3k0sd6kA2Em")
	
		.headers("Content-Type", "application/json")
		
		.body(reqPlaylist)
		
		.when()
		
		.post("users/31p6yxkpbqyn2ex2srl3rxb5n23i/playlists")
		
		.then()
		
		
		.body("name", equalTo("Playlist test using pojo"));
		
		
		
		
	}

	
	
}
