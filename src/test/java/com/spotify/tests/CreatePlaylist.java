package com.spotify.tests;

import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import api.SpecBuilders;

import static io.restassured.RestAssured.*;

public class CreatePlaylist {
	
	
	
	@Test
	
	public void createPlaylist()
	{
		Playlist reqPlaylist  = new Playlist();
		
		reqPlaylist.setName("Bhajan melody");
		reqPlaylist.setDescription("Spiritual content");
		reqPlaylist.setPublic(false);
		
		given()
		
		.spec(SpecBuilders.reqSpec())
		
		.body(reqPlaylist)
		
		.when()
		
		.post("users/31p6yxkpbqyn2ex2srl3rxb5n23i/playlists")
		
		.then()
		
		.spec(SpecBuilders.resSpec());
		
		
		
		
	}
	
	
	
	

}
