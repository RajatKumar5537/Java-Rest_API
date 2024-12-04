package RestAssured_API;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {

	@Test(priority  = 1)
	void testBasicAuthntication() {
		given()
			.auth()
			.basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
//	@Test(priority  = 2)
	void testDigestAuthntication() {
		given()
			.auth()
			.digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
//	@Test(priority = 3)
	void testPreemptiveAuthntication() {
		given()
			.auth()
			.preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
//	Bearer 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
	@Test(priority = 4)
	void testBearerTokenAuthntication() {
		String bearerToken = "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";
		
		given()
			.headers("Authorization","Bearer " + bearerToken) 
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	void test_OAuth1_Authntication() {
		given()
			.auth()
			.oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
			
			.auth()
			.oauth2("we need to pass the OAuth2 accessToken")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200);
	}
	
	void test_OAuth2_Authntication() {
		given()
			.auth().oauth2("we need to pass the OAuth2 accessToken")
		.when()
			.get()
		.then()
			.statusCode(200);
	}
	
	@Test
	void test_API_Key_Authntication() {
//		Method 1
		given()
			.queryParam("appid", "7acb383db14865b98b88199b3d451599")
		.when()
			.get("https://openweathermap.org/forecast16#parameter")
		.then()
		 	.statusCode(200)
		 	.log().all();
		
//		Method 2
//		api.openweathermap.org/data/2.5/weather?q=London,uk&callback=test&appid={API key}
		given()
			.pathParam("myPath", "data/2.5/weather")
			.queryParam("q", "London")
			.queryParam("q", "uk")
			.queryParam("callback", "test")
			.queryParam("appid", "43c0a78ee8edab5d40ac5d7c5e039c79")
		.when()
			.get("api.openweathermap.org/{myPath}")
		.then()
			.statusCode(200);
	}
}
