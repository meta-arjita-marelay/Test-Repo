package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Connection.ConnectionFactory;
import com.Properties.Query;
import com.entity.Advertisement;
import com.entity.Category;

public class MySQLAdvertisementDao implements AdvertisementDao {
	private static MySQLAdvertisementDao mysqlAdvertisementDao = new MySQLAdvertisementDao();

	public static MySQLAdvertisementDao getInstance() {
		return mysqlAdvertisementDao;
	}

	@Override
	public List<Advertisement> getAll() {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		String query = Query.SELECT_ALL_ADVERTISMENT;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}

	@Override
	public void create(Advertisement entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Advertisement t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Advertisement> getAllById(int id) {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		String query = Query.SELECT_ALL_ADVERTISMENT_BY_ID;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Advertisement advertisement = new Advertisement();
			while (resultSet.next()) {
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}

	@Override
	public void updateName(String name, int id) {
		String query = Query.UPDATE_NAME;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insert(Advertisement advertisement) {
		String query = Query.INSERT_NEW_ADVERTISEMENT;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, advertisement.getTitle());
			preparedStatement.setString(2, advertisement.getDescription());
			preparedStatement.setInt(3, advertisement.getCategory_id());
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		String query = Query.DELETE_ADVERTISEMENT;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			try{
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
			}catch(SQLException ex){
				System.out.println(ex);
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		
	}

	

	

}