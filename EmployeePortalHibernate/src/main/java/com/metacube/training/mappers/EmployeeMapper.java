package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.model.Employee;

/**
 * EmployeeMapper will map the employee object to database query result
 * 
 * @author Arjita
 *
 */
public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setCode(resultSet.getInt("code"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setMiddleName(resultSet.getString("middle_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		employee.setEmailId(resultSet.getString("email"));
		employee.setContact(resultSet.getString("contact"));
		employee.setSkypeId(resultSet.getString("skype_id"));
		employee.setProfilePicture(resultSet.getString("profile_picture"));
		employee.setPassword(resultSet.getString("password"));

		return employee;
	}
}
