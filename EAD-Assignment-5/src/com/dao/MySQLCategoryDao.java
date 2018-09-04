package com.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Connection.ConnectionFactory;
import com.Properties.Query;
import com.entity.Category;

public class MySQLCategoryDao implements CategoryDao {

	private static MySQLCategoryDao mysqlCategoryDao = new MySQLCategoryDao();

	public static MySQLCategoryDao getInstance() {
		return mysqlCategoryDao;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<Category>();
		String query = Query.SELECT_ALL_CATEGORIES;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("category"));
				categoryList.add(category);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}

	
	@Override
	public void insert(String name) {
		String query = Query.INSERT_NEW_CATEGORY;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void updateCategory(Category category, int id) {
		String query = Query.UPDATE_CATEGORY;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}

	}
	@Override
	public void create(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category t) {
		// TODO Auto-generated method stub

	}

}
