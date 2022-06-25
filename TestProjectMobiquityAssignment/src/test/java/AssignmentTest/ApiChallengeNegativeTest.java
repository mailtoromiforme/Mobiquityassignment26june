package AssignmentTest;
import org.testng.annotations.Test;

import BaseTest.Comments;
import BaseTest.Post;
import BaseTest.Users;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.util.List;


public class ApiChallengeNegativeTest  {   	

	@Test
	public void testValidateFormatOfEmailsInCommentsSectionForAllPostsOfAUserNegative()   {	
		
	
	Users users = new Users();
	Comments comments = new Comments();	
	Post posts = new Post();
	//JsonFileReader jsonReader = new JsonFileReader();	
	users.getResponseByUserName("NoTaUser");		
	List<Integer> userIdList= users.getListOfValuesOfIDInResponse();		
	for(Integer userId: userIdList) {			
			posts.getResponseByUserID(userId.toString());
			List<Integer> postIdList = posts.getListOfValuesOfPostIDInResponse();			
			for(Integer PostId: postIdList) {
				comments.getResponseByPostID(PostId.toString());
				System.out.println("PostId for " + PostId.toString());
				List<String> emails= comments.getListOfValuesOfEmailsInResponse();
				for (String item : emails) {
					boolean var = comments.isValid(item);		
					
					if (var =true) {
				    System.out.println(" email is valid for " + item);}					
				    else {System.out.println(" email is NOT valid for " + item);}	
					
				
				}
				
				
			}
		}
		
	}

}
