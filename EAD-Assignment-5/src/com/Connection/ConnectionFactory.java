package com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection class for JDBC Connectivity
 */
public class ConnectionFactory {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "Store";
	private static String mysqlURL = url + dbName;
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "user#123";
	private static Connection connection = null;

	/**
	 * Function to create connection with database
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(mysqlURL, username, password);
			} catch (SQLException ex) {
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return connection;
	}	
}
