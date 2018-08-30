package com.database;

public class QueryFactory {
	public static final String showEmployees = "SELECT e.first_name , e.last_name , e.email_id , e.age "
			+ "FROM employee e";

	public static final String updateEmployee =  "update employee as e "
			+ "set e.first_name = ? , "
			+ "e.last_name=? , "
			+ "e.email_id=? , "
			+ "e.age=? "
			+ "where e.email_id=? ";

	public static String addEmployee = "INSERT INTO "
			+ "employee(first_name , last_name , email_id , age) "
			+ "VALUES (?,?,?,?)";

	public static String searchEmployee = "SELECT e.first_name , e.last_name , e.email_id , e.age "
			+ "from employee e "
			+ "where concat(e.first_name , ' ' ,e.last_name) LIKE concat('%', ? ,'%') OR "
			+ "concat(e.last_name , ' ' , e.first_name) LIKE concat('%', ? ,'%')";


	
}
