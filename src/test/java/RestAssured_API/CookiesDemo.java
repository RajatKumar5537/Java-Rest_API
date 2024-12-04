package RestAssured_API;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class CookiesDemo {

//	@Test
	public void getCookies() {

		Response res = given()
				.when().get("https://www.google.com/");
		
//		Get single cookie value 
		String cookies_value = res.getCookie("AEC");
		System.out.println("Values of cookies -: " + cookies_value);
		
//		Get multiple cookies value 
		Map<String, String> cookies_values = res.getCookies();
		for (String cookie : cookies_values.keySet()) 
		{
			String cookieValue = res.getCookie(cookie);
			System.out.println(cookie + " : " + cookieValue);
		}
	}
}
