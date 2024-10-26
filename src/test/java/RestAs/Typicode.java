package RestAs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Typicode {
	@BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test(priority = 1)
    public void testGetRequest() {
        // Perform GET request with assertion on the title in the response body
        given()
            .when()
            	.get("/posts/1")
            .then()
	            .statusCode(200)
	            .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))  
	            .log().status()  
	            .log().body();   
    }

    @Test(priority = 2)
    public void testPostRequest() {
        // Create POST data
        Map<String, Object> postParams = new HashMap<>();
        postParams.put("title", "RestAssured");
        postParams.put("body", "Rajat");
        postParams.put("userId", 1);

        // Perform POST request with assertions on response body fields
        	given()
	            .contentType(ContentType.JSON)
	            .body(postParams)
            .when()
            	.post("/posts")
            .then()
	            .statusCode(201)
	            .body("title", equalTo("RestAssured")) // Chain multiple validations 
	            .body("body", equalTo("Rajat"))         
	            .body("userId", equalTo(1))             
	            .log().status()  
	            .log().body();   
    }

    @Test(priority = 3)
    public void testPutRequest() {
        // Create PUT data
        Map<String, Object> putParams = new HashMap<>();
        putParams.put("id", 1);
        putParams.put("title", "updated title");
        putParams.put("body", "updated body");
        putParams.put("userId", 1);

        // Perform PUT request with assertions on updated fields in response
        	given()
	            .contentType(ContentType.JSON)
	            .body(putParams)
            .when()
            	.put("/posts/1")
            .then()
	            .statusCode(200)
	            .body("title", equalTo("updated title"))   
	            .body("body", equalTo("updated body"))    
	            .body("userId", equalTo(1))               
	            .log().status() 
	            .log().body();   
    }

    @Test(priority = 4)
    public void testPatchRequest() {
        // Create PATCH data
        Map<String, Object> patchParams = new HashMap<>();
        patchParams.put("title", "patched title");

        // Perform PATCH request with assertion on patched title in response
        	given()
	            .contentType(ContentType.JSON)
	            .body(patchParams)
            .when()
            	.patch("/posts/1")
            .then()
	            .statusCode(200)
	            .body("title", equalTo("patched title"))   
	            .log().status()  
	            .log().body();   
    }

    @Test(priority = 5)
    public void testDeleteRequest() {
        // Perform DELETE request and assert status code, confirm deletion
        	given()
            .when()
            	.delete("/posts/1")
            .then()
	            .statusCode(200)  
	            .body(equalTo("{}")) 
	            .log().status() 
	            .log().body()
	            .time(lessThan(2000L));  // Asserts that the response time is less than 2000ms  
    }
}