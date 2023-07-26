package uploadanddownload;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

public class UploadAFile {
	
	
	@Test
	public void uploadFile()
	{
		File image = new File("C:\\Users\\DELL\\Desktop\\Test product image.png");
		
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
		given()
		
		.multiPart("file",image)
		
		.log().all()
		
		.when()
		
		.post("/upload")
		
		.then()
		
		.log().all();
		
		
		
	}

}
