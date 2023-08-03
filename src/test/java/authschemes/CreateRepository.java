package authschemes;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateRepository {
	@Test
	public void getRepository()
	{
		RestAssured.baseURI = "https://api.github.com";
		
		
		given()
		
		.header("Accept", "application/vnd.github+json")
		
		.header("Authorization", "Bearer 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")
		
		.header("X-GitHub-Api-Version", "2022-11-28")
		
		.body("{\r\n"
				+ "  \"name\": \"ATTEvening Repository\",\r\n"
				+ "  \"description\": \"Test repository for Bearer token\",\r\n"
				+ "  \"homepage\": \"https://github.com\",\r\n"
				+ "  \"private\": false,\r\n"
				+ "  \"is_template\": true\r\n"
				+ "}")
		
		.log().all()
		
		.when()
		
		.post("/user/repos")
		
		.then()
		
		.log().all();
		
		
		
	}
}
