package RestAssured_API;
/*
 * How many ways we create request body?
1.	HashMap
2.	Using org.json
3.	Using POJO (Plain Old Java Object)
4.	Using external JSON file

 */

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/*
		"id": "2",
		"name": "Swarna",
		"location": "India",
		"mobile": "34898598",
		"designation": [
		  "QA",
		  "Automation"
		]
*/

public class DifferentWayToCreatePostRequest {
//	@Test
	public void testPostUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "Ajit");
		data.put("location", "Dubai");
		data.put("mobile", "987623");
		
		String[] job = {"PM", "Crane"};
		
		data.put("designation", job);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/Employee")
		.then()
			.statusCode(201)
			.body("name", equalTo("Ajit"))
			.body("location", equalTo("Dubai"))
			.body("mobile", equalTo("987623"))
			.body("designation[0]",equalTo("PM"))
			.body("designation[1]", equalTo("Crane"))
			.header("content-type", "application/json")
			.log().all();
	}
	
//	@Test
	public void testPostUsingJSON_Library() {
		JSONObject input = new JSONObject();
		
		input.put("name", "Rohan");
		input.put("location", "London");
		input.put("mobile","1234");
		
		String[] job = {"MA", "Chef"};
		input.put("designation", job);
		
		given()
			.contentType("application/json")
			.body(input.toString())
		.when()
			.post("http://localhost:3000/Employee")
		.then()
			.statusCode(201)
			.body("name",equalTo("Rohan"))
			.body("location", equalTo("London"))
			.body("mobile", equalTo("1234"))
			.body("designation[0]", equalTo("MA"))
			.body("designation[1]", equalTo("Chef"))
			.log().all();
	}
	
//	@Test
	public void testPostUsingPOJO_Class() {
		Pojo_PostRequest data= new Pojo_PostRequest();
		data.setName("Swarna");
		data.setLocation("USA");
		data.setMobile("98761234");
		String[] arrays= {"Dev","Automation"};
		data.setDesignation(arrays);
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/Employee")
		.then()
			.statusCode(201)
			.body("name", equalTo("Swarna"))
			.body("location", equalTo("USA"))
			.body("mobile",equalTo("98761234"))
			.body("designation[0]", equalTo("Dev"))
			.body("designation[1]", equalTo("Automation"))
			.log().all();
	}
	
	@Test
	public void testPostUsingExternal_JSON_Class() throws FileNotFoundException  {
		File file = new File("./data.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonToken = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonToken);
		
		given()
			.contentType("application/json")
			.body(jsonObject.toString())
		.when()
			.post("http://localhost:3000/Employee")
		.then()
			.statusCode(201)
			.body("name", equalTo("Swarna"))
			.body("location", equalTo("USA"))
			.body("mobile",equalTo("98761234"))
			.body("designation[0]", equalTo("Dev"))
			.body("designation[1]", equalTo("Automation"))
			.log().all();
	}
}
