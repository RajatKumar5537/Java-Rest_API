package RestAssured_API;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameter {

//	https://reqres.in/api/users?page=2
	
	@Test
	public void testPathAndQueryParamet() {
		
		given()
			.pathParam("myPath", "users")
			.queryParam("page",2)
		.when()
			.get("https://reqres.in/api/{myPath}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
