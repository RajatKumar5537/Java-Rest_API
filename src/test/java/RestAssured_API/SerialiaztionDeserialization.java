package RestAssured_API;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerialiaztionDeserialization {

	@Test
	void convertPojoToJson() throws JsonProcessingException {
		Pojo_PostRequest data = new Pojo_PostRequest();
		
		data.setName("Swarna");
		data.setLocation("USA");
		data.setMobile("98761234");
		String[] arrays= {"Dev","Automation"};
		data.setDesignation(arrays);
		
//		convert java object ---> Json object (Serialization)
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData = objMapper.writeValueAsString(data);
		
		System.out.println(jsonData);
	}
	
	
//	convert JSON object ---> JAVA object (De-Serialization)
	@Test
	void convertJsonToPojo() throws JsonProcessingException {
		
//		Regular expression in Java
		String jsonData = " {\r\n"
				+ "  \"name\" : \"Swarna\",\r\n"
				+ "  \"location\" : \"USA\",\r\n"
				+ "  \"mobile\" : \"98761234\",\r\n"
				+ "  \"designation\" : [ \"Dev\", \"Automation\" ]\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		Pojo_PostRequest empPojo = objMapper.readValue(jsonData, Pojo_PostRequest.class);
		
		System.out.println("Emp name -: " + empPojo.getName());
		System.out.println("Emp Location -: " + empPojo.getLocation());
		System.out.println("Emp mobile -: " + empPojo.getMobile());
		
	}
}
