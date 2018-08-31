package Controller.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.database.ConnectionFactory;

import Model.pojos.*;
public class UserService {
	public static void addUser(UserDetails userDetails){
		String queryString = "INSERT INTO "
				+ "userDetails('first_name' , 'last_name' , 'email_id' , 'dob' ,"
				+ " 'user_password' , 'contact_number' , 'org_name') "
				+ "VALUES(? , ? , ? , ? , ? , ? , ?)";
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, userDetails.getFirstName());
				statement.setString(2, userDetails.getLastname()));
				statement.setString(3, userDetails.getEmailId());
				statement.setInt(4, userDetails.getDob());
				statement.addBatch();
				statement.executeBatch();
			} catch (SQLException ex) {
				throw new SQLException(ex);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	}
}
