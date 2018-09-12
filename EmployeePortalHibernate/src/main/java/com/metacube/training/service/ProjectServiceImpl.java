package com.metacube.training.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.DAOInterface;
import com.metacube.training.model.Project;

@Service
public class ProjectServiceImpl implements ServiceInterface<Project> {

	@Autowired
	private DAOInterface<Project> projectDAOInterface;

	@Override
	public Project getInfoById(int id) {
		return projectDAOInterface.getInfoById(id);
	}

	@Override
	public List<Project> getAllInfo() {
		return projectDAOInterface.getAllInfo();
	}

	@Override
	public boolean deleteInfo(int id) {
		return projectDAOInterface.deleteInfo(id);
	}

	@Override
	public boolean updateInfo(Project project) {
		return projectDAOInterface.updateInfo(project);
	}

	@Override
	public boolean create(Project project) {
		return projectDAOInterface.create(project);
	}

//	public boolean validateLogin(String email , String password) {
//		return projectDAOInterface.validateLogin(email,password);
//	}
}
