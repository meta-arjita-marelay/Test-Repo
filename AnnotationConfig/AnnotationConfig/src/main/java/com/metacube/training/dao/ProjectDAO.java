package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;
import com.metacube.training.util.ConnectionFactory;
import com.metacube.training.util.Status;

public class ProjectDAO {

	
	private final String SQL_FIND_PROJECT = "select * from project where id = ?";
	private final String SQL_DELETE_PROJECT = "delete from project where id = ?";
	private final String SQL_UPDATE_PROJECT = "update project set name = ?, description = ?, start_date  = ?, end_date  = ? where id = ?";
	private final String SQL_GET_ALL = "select * from project";
	private final String SQL_INSERT_PROJECT = "insert into project(name, description, start_date, end_date) values(?,?,?,?)";

	public Project getProjectById(Long id) {
		String queryString = SQL_FIND_PROJECT;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setLong(1, id);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();
				Project project = new Project();
				project.setProjectId(resultSet.getInt("id"));
				project.setDescription(resultSet.getString("description"));
				project.setName(resultSet.getString("name"));
				project.setStartDate(resultSet.getDate("start_date"));
				project.setEndDate(resultSet.getDate("end_date"));
				return project;
				
			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public List<Project> getAllProjects() {
		String queryString = SQL_GET_ALL;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				ResultSet resultSet = statement.executeQuery();
				List<Project> projects = new ArrayList<Project>();
				Project project = new Project();
				while(resultSet.next()){
					project.setDescription(resultSet.getString("description"));
					project.setName(resultSet.getString("name"));
					project.setStartDate(resultSet.getDate("start_date"));
					project.setEndDate(resultSet.getDate("end_date"));
					projects.add(project);
				}
				return projects;
				
			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean deleteProject(Project project) {
		String queryString = SQL_DELETE_PROJECT;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setInt(1, project.getProjectId());
				int rowsAffected = statement.executeUpdate();
				if(rowsAffected == 1){
				return true;
				}
				else{
					return false;
				}
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		
	}

	public boolean updateProject(Project project) {
		String queryString = SQL_UPDATE_PROJECT;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				
				statement.setString(1, project.getName());
				statement.setString(2, project.getDescription());
				statement.setDate(3, (Date) project.getStartDate());
				statement.setDate(4, (Date) project.getEndDate());
				statement.setInt(5 , project.getProjectId());
				int rowsAffected = statement.executeUpdate();
				
				if(rowsAffected == 1){
					return true;
					}
					else{
						return false;
					}
				} catch (SQLException ex) {
					return false;
				}
			} catch (SQLException e) {
				return false;
			}
			
	}

	public boolean createProject(Project project) {
		String queryString = SQL_INSERT_PROJECT;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, project.getName());
				statement.setString(2 ,project.getDescription());
				statement.setDate(3 , (Date) project.getStartDate());
				statement.setDate(4 , (Date) project.getEndDate());
				int rowsAffected = statement.executeUpdate();
				
				if(rowsAffected == 1){
					return true;
					}
					else{
						return false;
					}
				} catch (SQLException ex) {
					return false;
				}
			} catch (SQLException e) {
				return false;
			}
		
	}

}