package RestAssuredActivities;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetPet {
	// Base URL
	String ROOT_URI = "https://petstore.swagger.io/v2/pet/";

	// Test case using a DataProvider
	@Test(dataProvider = "petIdProvider")
	public void simple_get_test(String id) {
		Response response = given().contentType(ContentType.JSON) // Set headers
	        .when().get(ROOT_URI + id); // Send GET request

	    // Print response
	    System.out.println(response.asPrettyString());
	    // Assertions
	    response.then().body("status",Matchers.equalTo("null"));
	    
	}

	@DataProvider
	public Object[][] petIdProvider() {
	    // Setting parameters to pass to test case
	    Object[][] testData = new Object[][] { { "77232" }, { "133" } };
	    return testData;
	}

}
