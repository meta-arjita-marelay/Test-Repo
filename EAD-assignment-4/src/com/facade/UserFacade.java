package com.facade;

import java.sql.SQLException;
import java.util.List;

import com.Model.UserDetails;
import com.dao.UserService;
import com.enums.Status;

public class UserFacade {
	public static Status addUser(UserDetails userDetails) {
		
			List<String> usersEmail = null;
			try {
				usersEmail = UserService.getEmail();
				for (String email : usersEmail) {
					if (userDetails.getEmailId().equals(email)) {
						return Status.DUPLICATE;
					}
			} 
			}catch (SQLException e) {
				System.out.println(e);
			}
			return UserService.addUser(userDetails);
	}
	public static Status checkLoginValidity(String email , String password) throws SQLException{
		List<Integer> users = UserService.loginValidity(email, password);
		if(users.size()==1){
			return Status.VALID;
		}
		return Status.INVALID;
 	}
	
	public static Status updateUser(UserDetails userDetails){
		int updateRows = UserService.updateEmployee(userDetails);
		if(updateRows == 1 || updateRows==0){
			return Status.SUCCESS;
		}
		else{
			return Status.FAIL;
		}
	}
	
	public static void getFriendList(String email){
		
	}
	
	/*public static void main(String[] args){
		try {
			System.out.println(UserFacade.checkLoginValidity("arjita101@gmail.com", "Arjita@1234"));
		} catch (SQLException e) {
			System.out.println(e);
		}
	}*/
}
