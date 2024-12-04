package RestAssured_API;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class LocalAPI {

//	@Before
//	public void setup() {
//		baseURI = "http://localhost:3000/";
//	}

	@Test
	public void getRequest() {
		baseURI = "http://localhost:3000/";

		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(200)
			.log().body();
	}

	@Test
	public void postRequest() {
		baseURI = "http://localhost:3000/"; // http://localhost:3000/User
		JSONObject data = new JSONObject();
		data.put("FirstName", "Rudrani");
		data.put("LastName", "Prasad");
		data.put("Job", "Railway");
		data.put("id", 5);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(data.toJSONString())
		.when()
			.post("User")
		.then()
			.statusCode(201)
			.log().body();
	}
	
	@Test
	public void putRequest() {
		baseURI = "http://localhost:3000/";
		JSONObject data = new JSONObject();
		data.put("FirstName", "Emran Khan");
		data.put("LastName", "Pal");
		data.put("Job", "BankOfficer");
		
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(data.toJSONString())
		.when()
			.put("User/5")
		.then()
			.statusCode(200)
			.log().body();
	}

	@Test
	public void deleteRequest() {
		baseURI = "http://localhost:3000/";
		given()
		.when()
			.delete("User/5")
		.then()
			.statusCode(200);
	}
}
