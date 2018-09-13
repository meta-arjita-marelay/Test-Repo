package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAO implements DAOInterface<Project> {

	private JdbcTemplate jdbcTemplate;


	@Autowired
	   private SessionFactory sessionFactory;
	
	/*@Autowired
	public ProjectDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/

	private final String SQL_INSERT_PROJECT = "insert into project_master(name, description, start_date, end_date, project_logo) values(?,?,?,?,?)";
	private final String SQL_GET_ALL = "SELECT * FROM project_master ";
	private final String SQL_FIND_PROJECT = "SELECT * FROM project_master WHERE project_id = ?";
	private final String SQL_DELETE_PROJECT = "delete from project_master where project_id = ?";
	private final String SQL_UPDATE_PROJECT = "UPDATE project_master SET name = ? , description = ? , start_date = ? , end_date = ? , project_logo = ?"
			+ " WHERE project_id = ?";

	// private final String SQL_CHECK_LOGIN =
	// "SELECT * FROM project_master WHERE email = ?";

	@Override
	public Project getInfoById(int id) {
		return (Project) jdbcTemplate.queryForObject(SQL_FIND_PROJECT,
				new Object[] { id }, new ProjectMapper());
	}

	@Override
	public List<Project> getAllInfo() {
		return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
	}

	@Override
	public boolean deleteInfo(int id) {
		return jdbcTemplate.update(SQL_DELETE_PROJECT, id) > 0;
	}

	@Override
	public boolean updateInfo(Project project) {
		return jdbcTemplate.update(SQL_UPDATE_PROJECT,
				project.getDescription(), project.getStartDate(),
				project.getEndDate(), project.getProject_logo(),
				project.getId()) > 0;
	}

	@Override
	public boolean create(Project project) {
		/*return jdbcTemplate.update(SQL_INSERT_PROJECT,
				project.getDescription(), project.getStartDate(),
				project.getEndDate(), project.getProject_logo()) > 0;*/
				System.out.println("in dao");
				sessionFactory.getCurrentSession().save(project);
				System.out.println("after query");
				return true;
				/*System.out.println(result);
				if(result == 1){
					return true;
				}
				return false;*/
	}

	// public boolean validateLogin(String email , String password) {
	// return jdbcTemplate.update(SQL_INSERT_PROJECT, email,password) > 0;
	// }

}