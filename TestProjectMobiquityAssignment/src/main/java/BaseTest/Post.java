package BaseTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
public class Post extends RestTemplateUtil{
	
	
	
	private String ENDPOINT= "posts/";
	
	private static final String POST_ID= "id";
	
	private static final String USER_ID = "userId";
	
	private Response response;
	
	public Response getResponse() {
		return response;
	}
	@Test
	public Response getResponseByUserID(String ID) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(USER_ID, ID);
		
		response = executeGet(ENDPOINT, param);
		
		return response;
	}
	@Test
	public Response getResponseByPostID(String ID) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(POST_ID, ID);
		//LOG.info("Executing GET request to Posts API with " +POST_ID+"="+ ID);
		response = executeGet(ENDPOINT, param);
		//LOG.info("Response of Posts API: "+ response.asString());
		return response;
	}
	@Test
	public Response postRequest(JSONObject request) {
		response = executePost(ENDPOINT, request);
		return response;
	}
	@Test
	public List<Integer> getListOfValuesOfUserIDInResponse() {
		return response.jsonPath().getList(USER_ID);
	}
	@Test
	public List<Integer> getListOfValuesOfPostIDInResponse() {
		return response.jsonPath().getList(POST_ID);
	}
}

