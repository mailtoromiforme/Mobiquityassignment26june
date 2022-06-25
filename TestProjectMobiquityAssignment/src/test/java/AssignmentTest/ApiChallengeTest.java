package AssignmentTest;
import org.testng.annotations.Test;

import BaseTest.Comments;
import BaseTest.Post;
import BaseTest.Users;

import java.util.List;


public class ApiChallengeTest  {   	

	@Test
	public void testValidateFormatOfEmailsInCommentsSectionForAllPostsOfAUser()   {	
		
	
	Users users = new Users();
	Comments comments = new Comments();	
	Post posts = new Post();
	//JsonFileReader jsonReader = new JsonFileReader();	
	users.getResponseByUserName("Delphine");		
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
