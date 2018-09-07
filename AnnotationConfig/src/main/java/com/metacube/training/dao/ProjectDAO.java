package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectDAO {
	
	
	Project getProjectById(Long id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);
}
