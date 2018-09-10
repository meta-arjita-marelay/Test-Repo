package com.metacube.training.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectDB is used to create a connection between client and database.
 * @author Arjita
 *
 */
public class ConnectionFactory {
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName(DatabaseProperties.driver);
			String url = DatabaseProperties.url;
			String user = DatabaseProperties.dbuser;
			String password = DatabaseProperties.dbpassword;
			conn = (Connection) DriverManager.getConnection(url, user,
					password);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		System.out.println(ConnectionFactory.getconnection());
	}
}


