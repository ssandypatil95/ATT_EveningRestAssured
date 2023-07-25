package sendingbodyasobject;

public class BodyCreator {
	
	public static String getBody()
	{
		String body = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"userone\",\r\n"
				+ "  \"firstName\": \"userfirstname\",\r\n"
				+ "  \"lastName\": \"userlastname\",\r\n"
				+ "  \"email\": \"user.user@att.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543223\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}";
		
		return body;
	}

}
