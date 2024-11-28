package RestAs;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestApiRaghab {

	/*
	 * @Test public void getResponse() {
	 * 
	 * Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	 * 
	 * System.out.println("status code is -> "+response.getStatusCode());
	 * System.out.println(response.getContentType());
	 * System.out.println("time is -> "+response.getTime());
	 * System.out.println(response.getBody().asString());
	 * System.out.println(response.getStatusLine());
	 * System.out.println(response.getHeader("content-type"));
	 * 
	 * int statusCode = response.getStatusCode(); Assert.assertEquals(statusCode,
	 * 200);
	 * 
	 * }
	 * 
	 * // @Test public void getRequest() { // String baseUrl = "https://reqres.in/";
	 * 
	 * given()
	 * 
	 * .when() .get("https://reqres.in/api/users?page=2")
	 * 
	 * .then() .statusCode(200) .body("page", equalTo(2))
	 * .body("data[4].first_name", equalTo("George")) .log().all();
	 * 
	 * }
	 * 
	 * @Test public void postRequest() { Map<String , Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * JSONObject request = new JSONObject(); request.put("name", "Rajat");
	 * request.put("job", "QA Analyst");
	 * 
	 * 
	 * given() .body(request.toJSONString()) .when()
	 * .post("https://reqres.in/api/users")
	 * 
	 * 
	 * .then() .statusCode(201); // .log().all(); }
	 */

	@Test
	public void practice() {

//		Map<String, Object> data = new HashMap<String, Object>();
//
//		data.put("name", "Rajat");
//		data.put("job", "TE");
//
//		System.out.println(data);

		JSONObject request = new JSONObject();

		request.put("name", "Rajat");
		request.put("job", "ATE");

		RestAssured.baseURI = "https://reqres.in/api/";

		given()
				.body(request.toJSONString())
			.when()
				.put("/users/2")
			.then()
				.statusCode(200)
				.log().all();
		
		
	}
}
