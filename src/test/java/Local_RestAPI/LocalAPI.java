package Local_RestAPI;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class LocalAPI {

	
	@Test
	public void getRequest() {
		
		baseURI = "http://localhost:3000/";
		
		given()
		
		.when()
			.get("products")
		.then()
			.statusCode(200);
//			.log().all();
	}
	
	@Test
	public void postRequest() {
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("name", "HP World");
		request.put("brand", "HP");
		request.put("price", 40000);
		request.put("category", "Electronis");
		request.put("stock", 40);	
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("products")
		.then()
			.statusCode(201)
			.log().all();
	}
	
//	@Test
	public void putRequest() {
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("name", "HP World Electronic");
		request.put("brand", "HP World");
		request.put("price", 40000);
		request.put("category", "Electronis");
		request.put("stock", 40);	
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("products")
		.then()
			.statusCode(200)
			.log().all();
	}
}
