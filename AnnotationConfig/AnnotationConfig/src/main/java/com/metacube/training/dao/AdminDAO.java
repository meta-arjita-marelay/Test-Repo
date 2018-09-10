package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;
import com.metacube.training.util.*;

public class AdminDAO {

	public static Status insertEmployee(Employee employee) {
		String queryString = QueryFactory.insertEmployee;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, employee.getFirstName());
				statement.setString(2, employee.getMiddleName());
				statement.setString(3, employee.getLastName());
				statement.setDate(4, employee.getDob());
				statement.setString(5, employee.getGender());
				statement.setString(6, employee.getPrimaryContact());
				statement.setString(7, employee.getSecondaryContact());
				statement.setString(8, employee.getEmailId());
				statement.setString(9, employee.getSkypeId());
				statement.setString(10, employee.getProfilePicture());
				statement.setString(11, employee.getPassword());
				statement.setBoolean(12, employee.getEnabled());

				statement.executeUpdate();
				return Status.SUCCESS;

			} catch (SQLException ex) {
				return Status.FAILURE;
			}
		} catch (SQLException e) {
			return Status.FAILURE;
		}
	}

	public Status addProject(Project project) {
		String queryString = QueryFactory.addProject;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setInt(1, project.getProjectId());
				statement.setString(2, project.getDescription());
				statement.setDate(3, (Date) project.getStartDate());
				statement.setDate(4, (Date) project.getEndDate());
				statement.setString(5, project.getProjectLogo());
				statement.executeUpdate();
				
				return Status.SUCCESS;
			} catch (SQLException ex) {
				return Status.FAILURE;
			}
		} catch (SQLException e) {
			return Status.FAILURE;
		}
	}

	public Status updateProject(Project project) {
		String queryString = QueryFactory.updateProject;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, project.getDescription());
				statement.setDate(2, (Date) project.getStartDate());
				statement.setDate(3, (Date) project.getEndDate());
				statement.setString(4, project.getProjectLogo());
				statement.setInt(5, project.getProjectId());
				statement.executeUpdate();
				
				return Status.SUCCESS;
			} catch (SQLException ex) {
				return Status.FAILURE;
			}
		} catch (SQLException e) {
			return Status.FAILURE;
		}
	}

	public static Status updateEmployeeStatus(String empCode , Boolean status){
		String queryString = QueryFactory.updateEmployeeStatus;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1,empCode);
				statement.setBoolean(2, status);
				statement.executeUpdate();
				
				return Status.SUCCESS;
			} catch (SQLException ex) {
				return Status.FAILURE;
			}
		} catch (SQLException e) {
			return Status.FAILURE;
		}
	}
	
	public static String getPassword(String empCode){
		String queryString =QueryFactory.getPassword;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, empCode);
				ResultSet resultSet =  statement.executeQuery();
				resultSet.next();
				String password = resultSet.getString("password");
				return password;
				
			
			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
