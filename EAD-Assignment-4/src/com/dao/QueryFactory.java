package com.dao;

public class QueryFactory {
	public static final String insertString = "INSERT INTO "
			+ "userDetails(first_name , last_name , email_id , dob ,"
			+ " user_password , contact_number , org_name) "
			+ "VALUES(? , ? , ? , ? , ? , ? , ?)";

	public static final String getEmailOfUsers = "SELECT u.email_id "
			+ "FROM userDetails u";
	
	public static final String loginValidity = "SELECT u.user_id "
			+ "FROM userDetails u "
			+ "WHERE u.email_id = ? AND u.user_password = ?";
	
	public static final String getId = "SELECT * "
			+ "FROM userDetails u "
			+ "WHERE u.email_id = ?" ;
}
