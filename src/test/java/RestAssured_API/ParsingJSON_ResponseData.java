package RestAssured_API;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSON_ResponseData {

//	@Test
	void parsingJsonResponse() 
	{
		given()
		.when()
			.get("http://localhost:3000/Employee")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.body("[1].name", equalTo("Rajat Kumar"));
	}
	
//	@Test
	void parsingJsonResponse_Use_Variable() {
		
		Response response = given()
						.contentType(ContentType.JSON)
					.when()
						.get("http://localhost:3000/Employee");
		
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		
		String name = response.jsonPath().get("[1].name").toString();
		Assert.assertEquals(name, "Rajat Kumar");
	}
	
	@Test
	void parsingJson_using_JSONObject() {
		
		Response response = given()
				.contentType(ContentType.JSON)
			.when()
				.get("http://localhost:3000/Employee");
		
		JSONObject jsonObject = new JSONObject(response.toString()); // converting response ro JSON object type 
		
		for( int i = 0; i < jsonObject.getJSONArray("Employee").length() ; i++) 
		{
			String name = jsonObject.getJSONArray("Employee").getJSONObject(i).get("name").toString();
			System.out.println(name);
		}
	}
	
}
