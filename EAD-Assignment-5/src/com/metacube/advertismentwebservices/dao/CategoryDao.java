package com.metacube.advertismentwebservices.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertismentwebservices.Common.ConnectionFactory;
import com.metacube.advertismentwebservices.Properties.Query;
import com.metacube.advertismentwebservices.model.Category;

/**
 * CategoryDao is for performing insertion , deletion and updation operations on
 * category table
 */
public class CategoryDao {

	private static CategoryDao mysqlCategoryDao = new CategoryDao();

	/**
	 * method to create singleton object
	 * 
	 * @return
	 */
	public static CategoryDao getInstance() {
		return mysqlCategoryDao;
	}

	/**
	 * method to get all the categories
	 * 
	 * @return list of all categories
	 */
	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<Category>();
		String query = Query.SELECT_ALL_CATEGORIES;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn
						.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				categoryList.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	/**
	 * method to insert the data in the category table
	 * 
	 * @param name
	 *            of category to be inserted
	 */
	public void insert(String name) {
		String query = Query.INSERT_NEW_CATEGORY;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn
						.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}

	}

	/**
	 * method to update the name of the category
	 * 
	 * @param name
	 *            new name of category
	 * @param id
	 *            id of category which is to be updated
	 */
	public void updateCategory(String category, int id) {
		String query = Query.UPDATE_CATEGORY;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn
						.prepareStatement(query);) {
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}

	}

}
