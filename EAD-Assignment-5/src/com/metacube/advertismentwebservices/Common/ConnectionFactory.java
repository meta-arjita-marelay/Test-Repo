package com.metacube.advertismentwebservices.Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection class for JDBC Connectivity
 */
public class ConnectionFactory {
	private static String url = "jdbc:mysql://localhost:3306/Store";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "user#123";
	private static Connection connection = null;

	/**
	 *method to create connection with database
	 * @return connection to database
	 */
	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return connection;
	}	
}