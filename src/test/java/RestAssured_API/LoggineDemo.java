package RestAssured_API;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggineDemo {

	@Test
	public void getLog() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().body()
			.log().cookies()
			.log().headers();
		
	}
}
