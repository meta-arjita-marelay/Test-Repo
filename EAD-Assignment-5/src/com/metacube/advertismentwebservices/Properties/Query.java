package com.metacube.advertismentwebservices.Properties;

/**
 * Class containing all the queries
 */
public class Query {
	public static final String INSERT_NEW_CATEGORY = "INSERT INTO category (name)"
			+ " VALUES (?)";
	
	public static final String SELECT_ALL_CATEGORIES = "SELECT * "
			+ "FROM category";
	
	public static final String SELECT_ALL_ADVERTISMENT = "SELECT * "
			+ "FROM advertisement";
	
	public static final String SELECT_ALL_ADVERTISMENT_BY_ID = "SELECT * "
			+ "FROM advertisement "
			+ "WHERE category_id=?";
	
	public static final String UPDATE_NAME = "UPDATE advertisement "
			+ "SET title=? "
			+ " WHERE id=?";
	
	public static final String INSERT_NEW_ADVERTISEMENT = "INSERT INTO "
			+ "advertisement (title, description , category_id)"
			+ " VALUES (?,?,?)";
	
	public static final String UPDATE_CATEGORY = "UPDATE name"
			+ " SET category = ? "
			+ "WHERE id = ? ";
	
	public static final String DELETE_ADVERTISEMENT = "DELETE FROM advertisement "
			+ "WHERE id = ? ";
}
