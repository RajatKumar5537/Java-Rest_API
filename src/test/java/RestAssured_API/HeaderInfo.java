package RestAssured_API;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderInfo {

//	@Test
	public void getHeader() {
		given()
			.when()
				.get("https://www.google.com/")
			.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip").header("Server", "gws");
	}

	@Test
	public void getHeaders() {

		Response response = given().when().get("https://www.google.com/");

		String headerValue = response.getHeader("Content-Type");
		System.out.println("Value of content type-: " + headerValue);

		Headers headersValue = response.getHeaders();

		for (Header header : headersValue) {
			System.out.println(header.getName() + " : " + header.getValue());
		}

	}
}
