package uploadanddownload;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class DownloadFile {
	
	@Test
	public void downloadAFile() throws IOException
	{
		String path  = "F:\\Desktop\\VimanNagar\\ATT_Evening\\Downloaded file\\downloadedbycode.png";
		
		RestAssured.baseURI = "https://github.com";
		
		byte[] bytearray = given()
		
		.when()
		
		.get("/Vimannagar/ATT_EveningRestAssured/raw/master/src/test/resources/Test Product image2.png")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response()
		
		.asByteArray();
		
		FileOutputStream fos = new FileOutputStream(new File(path));
		
		fos.write(bytearray);
		
		fos.close();
			
	}

}
