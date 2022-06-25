package BaseTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;


public class Users extends RestTemplateUtil {
	
	//protected static Logger LOG = Logger.getLogger(Users.class);
	
	private String ENDPOINT= "users/";
	
	private static final String USER_ID= "id";
	
	private static final String USER_NAME = "username";
private Response response;
	
	public Response getResponse() {
		return response;
	}
	
	public Response getResponseByUserName( String name) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(USER_NAME, name);
		response = executeGet(ENDPOINT, param);
		return response;
	}
	
	public List<Integer> getListOfValuesOfIDInResponse() {
		return response.jsonPath().getList(USER_ID);
		//return null;
	}
	
	public List<String> getListOfValuesOfUserNameInResponse() {
		return response.jsonPath().getList(USER_NAME);
		//return null;
	}
}

