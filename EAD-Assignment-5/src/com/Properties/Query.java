package com.Properties;

public class Query {
	public static final String INSERT_NEW_CATEGORY = "INSERT INTO Category (name) VALUES (?)";
	public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM Category";
	public static final String SELECT_ALL_ADVERTISMENT = "SELECT * FROM Advertisement";
	public static final String SELECT_ALL_ADVERTISMENT_BY_ID = "SELECT * FROM Advertisement WHERE category_id=?";
	public static final String UPDATE_NAME = "UPDATE Advertisement SET title=? WHERE id=?";
}
