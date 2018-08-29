package com.database;

public class QueryFactory {
	public static final String showEmployees = "SELECT e.first_name , e.last_name , e.email_id , e.age "
			+ "FROM employee e";

	public static String addEmployee = "INSERT INTO "
			+ "employee(first_name , last_name , email_id , age) "
			+ "VALUES (?,?,?,?)";

}
