package BaseTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;



public class Comments extends RestTemplateUtil{
	
	
	private String ENDPOINT="comments/";
	
	private static final String POST_ID= "postId";
	
	private static final String EMAIL = "email";
	
	private Response response;
	
	public Response getResponse() {
		return response;
	}
	@Test
	public Response getResponseByPostID(String ID) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(POST_ID, ID);		
		response = executeGet(ENDPOINT, param);		
		return response;
	}
	@Test
	public List<String> getListOfValuesOfEmailsInResponse(){
		return response.jsonPath().getList(EMAIL);
	}
	@Test
	public boolean isValid(String email) {
		return ComparatorUtil.regexMatcher(email, "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	}
	
}
