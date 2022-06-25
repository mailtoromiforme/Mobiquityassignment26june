package BaseTest;
import org.junit.jupiter.api.BeforeAll;
public class Baseclass {
protected Users users;
	
	protected Post posts;	
	protected Comments comments;	
	protected JsonFileReader jsonReader;
	@BeforeAll
	public void beforeAll() {
		comments = new Comments();
		users = new Users();
		posts = new Post();
		//softAssert = new SoftAssertions();
		jsonReader = new JsonFileReader();
	}
	

}
