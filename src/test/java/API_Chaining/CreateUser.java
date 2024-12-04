package API_Chaining;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

public class CreateUser {

	Faker faker = new Faker();
	
	@Test
	void postUser() {
		
	JSONObject data = new JSONObject();
	
	data.put("name","Rajat");
	data.put("email", "nkdkno@gmail.com");
	data.put("status", "inactive");
	
	String barearToken = "612fb2ef78fcac307cd3a3bff004d80a511f1cfe79cda744f65c1a585eed2761"; 
			 
	 int id = given()
		.headers("Authorization","Bearer "+ barearToken) 
		.contentType("application/json")
		.body(data.toString())
	.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id"); 
//		.then()
//		.log().body();
	
	System.out.println("Generate id is : " + id);
	}
}
