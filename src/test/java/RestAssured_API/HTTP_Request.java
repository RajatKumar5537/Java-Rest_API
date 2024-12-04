package RestAssured_API;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTP_Request {

	int id;
	@Test(priority = 1)
	public void getUsers() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().status();
		
	}
	
	@Test(priority = 2)
	public void createUser() {
		HashMap data = new HashMap();
		data.put("name", "Rajat");
		data.put("job", "QA");
		
		id = given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
			
			
//		.then()
//			.statusCode(201)
//			.log().all();
			
	}
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	public void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "Raj");
		data.put("job", "Dev");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+ id)
		.then()
			.statusCode(200)
			.log().status();
	}
	
	@Test(priority = 4)
	public void deleteUser() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+ id)
		.then()
			.statusCode(204)
			.log().status();
	}
}
