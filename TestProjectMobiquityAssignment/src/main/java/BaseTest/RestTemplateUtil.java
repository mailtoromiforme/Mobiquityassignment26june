package BaseTest;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class RestTemplateUtil {

	String baseURI = "https://jsonplaceholder.typicode.com/";

	public Response executeGet(String endpoint, Map<String, String> params) {

	return given().contentType(ContentType.JSON).baseUri("https://jsonplaceholder.typicode.com/").headers(createHeaders()).params(params)
				.get(endpoint);
			
	}

	protected Response executePost(String endpoint, JSONObject request) {
		return given().contentType(ContentType.JSON).baseUri(baseURI).headers(createHeaders()).body(request).when()
				.post(endpoint);
	}

	private Map<String, ?> createHeaders() {
		Map<String, Object> headers = new HashMap<String, Object>();
		return headers;
	}
}
