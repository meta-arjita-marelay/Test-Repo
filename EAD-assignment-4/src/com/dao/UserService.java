package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.Model.UserDetails;
import com.enums.Status;

;

public class UserService {
	public static Status addUser(UserDetails userDetails) {
		String queryString = QueryFactory.insertString;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, userDetails.getFirstName());
				statement.setString(2, userDetails.getLastname());
				statement.setString(3, userDetails.getEmailId());
				statement.setDate(4,
						new java.sql.Date((userDetails.getDob().getTime())));
				statement.setString(5, userDetails.getUserPassword());
				statement.setString(6, userDetails.getConNumber());
				statement.setString(7, userDetails.getOrgName());

				statement.executeUpdate();
				return Status.SUCCESS;

			} catch (SQLException ex) {
				System.out.println(ex);
				return Status.FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return Status.FAIL;
		}
	}

	public static List<String> getEmail() throws SQLException {
		String queryString = QueryFactory.getEmailOfUsers;
		List<String> listOfEmail = new ArrayList<String>();
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					String userEmailId = resultSet.getString("email_id");
					listOfEmail.add(userEmailId);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return listOfEmail;
	}

	public static List<Integer> loginValidity(String email, String password)
			throws SQLException {
		String queryString = QueryFactory.loginValidity;
		List<Integer> users = new ArrayList<Integer>();
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, email);
				statement.setString(2, password);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int userId = resultSet.getInt("user_id");
					users.add(userId);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return users;
	}

	public static UserDetails getDetails(String email) {
		String queryString = QueryFactory.getId;
		UserDetails userDetails = new UserDetails();
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, email);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();
				userDetails.setFirstName(resultSet.getString("first_name"));
				userDetails.setLastname(resultSet.getString("last_name"));
				userDetails.setEmailId(resultSet.getString("email_id"));
				userDetails.setDob(resultSet.getDate("dob"));
				userDetails.setConNumber(resultSet.getString("contact_number"));
				userDetails.setOrgName(resultSet.getString("org_name"));
				userDetails.setUserPassword(resultSet
						.getString("user_password"));
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return userDetails;
	}

	public static int updateEmployee(UserDetails userDetails) {
		String queryString = QueryFactory.updateUser;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, userDetails.getFirstName());
				statement.setString(2, userDetails.getLastname());
				statement.setString(3, userDetails.getConNumber());
				statement.setString(4, userDetails.getEmailId());
				int affectedRows = statement.executeUpdate();
				return affectedRows;
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static List<String> getFriends(String email) {
		String queryString = QueryFactory.getFriends;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, email);
				ResultSet resultSet = statement.executeQuery();
				List<String> friends = new ArrayList<String>();
				while (resultSet.next()) {
					friends.add(resultSet.getString("first_name"));
				}
				return friends;
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	/*
	 * public static void main(String[] args) throws SQLException { UserDetails
	 * users = UserService.getDetails("arjita101@gmail.com");
	 * System.out.println(users.getFirstName()); }
	 */

	/*
	 * public static void main(String[] args) { UserDetails userDetails = new
	 * UserDetails(); userDetails.setFirstName("Ärjita");
	 * userDetails.setLastname("Marelay");
	 * userDetails.setEmailId("arjita11@gmail.com"); try {
	 * userDetails.setDob(new
	 * SimpleDateFormat("yyyy-mm-dd").parse("1997-02-16")); }
	 * catch(ParseException e) { e.printStackTrace(); }
	 * userDetails.setUserPassword("Arjita@1234");
	 * userDetails.setConNumber("9907591320");
	 * userDetails.setOrgName("Metacube"); UserService.addUser(userDetails);
	 * 
	 * 
	 * }
	 */
	/*
	 * public static void main(String[] args) { try { List<String> emaillist =
	 * UserService.getEmail(); for(String email : emaillist){
	 * System.out.println(email); } } catch (SQLException e) {
	 * System.out.println(e); }
	 * 
	 * }
	 */
}
