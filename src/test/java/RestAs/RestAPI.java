package RestAs;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class RestAPI {

	int id; 
	
	@Test(priority = 1)
	public void getRequest() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
		
	}
	
	@Test(priority = 2)
	public void postRequest() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("name", "Rajat");
		data.put("job", "TE");
		
		id= given()
			.contentType("application/json")
			.body(data)	
		
		.when()
			.post(" https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
	}
	
	@Test(priority = 3)
	public void putRequest() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("name", "Swarna");
		data.put("job", "Student");
		
				given()
					.contentType("application/json")
					.body(data)
				.when()
					.put("https://reqres.in/api/users/"+ id)
				
				.then()
					.statusCode(200)
					.log().all();
	}
	
	@Test(priority = 4)
	public void deleteRequest() {
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+ id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
