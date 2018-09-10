package com.metacube.training.util;

public class QueryFactory {
	public static final String insertEmployee = "INSERT INTO Employee('emp_code' , 'first_name' "
			+ "'middle_name' , 'last_name' , 'dob' , 'gender' , 'primary_contact_no' "
			+ "'secondary_contact_no' , 'email' , 'skype_id' , 'profile_picture' , "
			+ "'password' , 'enabled') "
			+ "VALUES (? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ?)";
	
	public static final String addProject = "INSERT INTO Project('project_id' , 'description' , "
			+ " 'start_date' , 'end_date' , 'project_logo') "
			+ "VALUES (? , ? , ? , ? , ?)";
	
	public static final String updateProject = "UPDATE Project as p "
			+ "SET p.description = ? , "
			+ "p.start_date = ? , "
			+ "p.end_date = ? , "
			+ "p.project_logo = ? "
			+ "WHERE p.project_id = ?";
	
	public static final String updateEmployeeStatus="UPDATE Employee as e "
			+ "SET e.enabled = ? "
			+ "WHERE e.emp_code = ?";

	public static final String getPassword = "SELECT e.password"
			+ "FROM Employee e"
			+ "WHERE e.emp_code = ?";
}
