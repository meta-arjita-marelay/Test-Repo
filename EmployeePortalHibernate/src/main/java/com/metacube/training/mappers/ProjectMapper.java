package com.metacube.training.mappers;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Project;

/**
 * ProjectMapper will map the project object with database query result
 * 
 * @author Arjita
 *
 */
public class ProjectMapper implements RowMapper<Project> {

	public Project mapRow(ResultSet resultSet, int i) throws SQLException {

		Project projectMaster = new Project();
		projectMaster.setId(resultSet.getInt("project_id"));
		projectMaster.setDescription(resultSet.getString("description"));
		projectMaster.setStartDate(resultSet.getDate("start_date"));
		projectMaster.setEndDate(resultSet.getDate("end_date"));
		projectMaster.setProject_logo(resultSet.getString("project_logo"));

		return projectMaster;
	}
}
