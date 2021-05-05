package RestAssuredActivities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ChallengeActivity {
	// Declare request specification
	RequestSpecification requestSpec;
	// Declare response specification
	ResponseSpecification responseSpec;
	String sshkey;
	int sshkeyid;

	@BeforeClass
	public void setUp() {
		// Create request specification
		requestSpec = new RequestSpecBuilder()
				// Set content type
				.setContentType(ContentType.JSON).addHeader("Authorization", "token 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")
				// Set base URL
				.setBaseUri("https://api.github.com")
				// Build request specification
				.build();
		sshkey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC2dY9Pe4aSRA7j6S8PTIYjp5LO32qvsdIfl64Gx5oGvwHDqxq9+6MacCSjDKG67OVuOS2t1vpQ1+4yglVge27KIkNJ3+V7QjK8/ZjbuKrslUeeB/9orqWcIzm2rzq5yJHTfg5V3BJosYEDIdNy7ojZfDqSPWALzu9ftkssFulwlQ/z+2v6kVGlFVhVQRd/jpb/cfkXK+jFKIBuNw0qq7h2Y1v+KAFkqHwBHxiBCu6XxIeGAeMPAWfp8Gy+jcyoD4nWPnGsuOKU/FFYAhq40c8Bi2/x3OrkH6vclRARXFVP3YD9EVf3sMyRYUykd2WyYlff4cUKyEac2PIdU0gebwh1";

	}

	@Test(priority = 1)
	
	public void addKey() {
		String reqBody = "{\"title\": \"TestKey\", \"key\": \"" + sshkey + "\"}";
		Response response = given().spec(requestSpec) // Use requestSpec
				.body(reqBody) // Send request body
				.when().post("/user/keys"); // Send POST request
		String resBody = response.getBody().asPrettyString();
		System.out.println(resBody);
		sshkeyid = response.then().extract().path("id");

		// Assertions
		response.then().statusCode(201);
	}


	@Test(priority = 2)
	public void getkey() {
		Response response = given().spec(requestSpec) // Use requestSpec
				.when().get("/user/keys"); // Send GET request

		String resBody = response.getBody().asPrettyString();

		// Print response
		System.out.println(resBody);
		// Assertions
		response.then().statusCode(200);

	}

	
	@Test(priority = 3)
	public void deleteKey() {
		Response response = given().spec(requestSpec) // Use requestSpec
				.pathParam("keyId", sshkeyid) // Add path parameter
				.when().delete("/user/keys/{keyId}"); // Send GET request

		String resBody = response.getBody().asPrettyString();

		// Print response
		System.out.println(resBody);
		// Assertions
		response.then().statusCode(204);
	}
}