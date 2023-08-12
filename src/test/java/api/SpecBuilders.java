package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
	
	
	public static RequestSpecification reqSpec()
	{
		return new RequestSpecBuilder()
		
		.setBaseUri("https://api.spotify.com")	
		
		.setBasePath("/v1")
		
		.addHeader("Authorization", "Bearer BQCoF6ypBLCEOlOaOjxLIOCDZkc30S0e-HgZI8pSMgOj1_bxB4HFmohmtov8cMoCYXcAq9ql7yR-Edp4IfMddmCZUIjm677xmet85MpnsNLTZo3M7R4osOi6Dw63kG1DvfHIhPSMLPkhXWsrLA4pknatBDyJX0Af-TSf4UPe4ZJcvE-Tl0mCYT79HX3nQntCkKu2jCuMoZlKEXpQIe6-sHXjvlSPU7dmBpWZXFLqFZbnnC4crWOQ6CLKjtFSmihtGDNWeX548I9_8lnr")
		
		.setContentType(ContentType.JSON)
		
		.log(LogDetail.ALL)
		
		.build();
	
	}
	
	public static ResponseSpecification resSpec()
	{
		return new ResponseSpecBuilder()
		
		.expectContentType(ContentType.JSON)
		
		.log(LogDetail.ALL)

		.build();
	}

}
