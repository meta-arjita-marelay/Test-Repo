package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.model.Employee;

@Repository
@Transactional
public class EmployeeDAO implements DAOInterface<Employee> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	// @Autowired
	// public EmployeeDAO(DataSource dataSource) {
	// jdbcTemplate = new JdbcTemplate(dataSource);
	// }

	private final String SQL_INSERT_EMPLOYEE = " INSERT INTO employee"
			+ "(first_name, middle_name, last_name, dob, gender, email, contact, skype_id,"
			+ "profile_picture, password) " + "VALUES "
			+ "(?,?,?,?,?,?,?,?,?,?)";

	private final String SQL_GET_ALL = "SELECT * " + "FROM employee "
			+ "WHERE enabled = 'true' ";

	private final String SQL_FIND_EMPLOYEE = "SELECT * " + "FROM employee "
			+ "WHERE code = ?";

	private final String SQL_GET_EMPLOYEE_BYEMAIL = "SELECT * "
			+ "FROM employee " + "WHERE email = ? ";

	private final String SQL_GET_EMPLOYEE_BY_NAME = "SELECT * "
			+ "FROM employee " + "WHERE first_name = ? ";

	private final String SQL_GET_EMPLOYEE_BY_PROJECT = "SELECT * "
			+ "FROM employee as E INNER JOIN employee_project EP "
			+ "on E.code = EP.employee_code "
			+ "INNER JOIN project_master as PM  "
			+ "on PM.project_id = EP.project_id "
			+ "WHERE PM.name = ? AND enabled = 'true'";

	private final String SQL_GET_EMPLOYEE_BY_SKILLS = "SELECT * "
			+ "FROM employee as E INNER JOIN employee_skills ES "
			+ "on E.code = ES.employee_code "
			+ "INNER JOIN skill_master as SM  on SM.skill_id = ES.skill_code "
			+ "WHERE SM.skill_name = ? AND enabled = 'true'; ";

	private final String SQL_GET_EMPLOYEE_BY_EXPERIENCE = "SELECT * "
			+ "FROM employee as E INNER JOIN job_details JD "
			+ "on E.code = JD.employee_code "
			+ "WHERE JD.total_experience  = ? ";

	private final String SQL_UPDATE_EMPLOYEE = "UPDATE employee "
			+ "SET first_name = ? , middle_name = ? , last_name = ? , dob = ? , gender = ?,"
			+ " email = ? , contact = ? , skype_id = ? , profile_picture = ? WHERE code = ?";

	private final String SQL_Disable_Employee = "UPDATE employee "
			+ "SET enabled = 'false'  WHERE code = ?";

	private final String SQL_UPDATE_PASSWORD = "UPDATE employee "
			+ "SET password = ? WHERE email = ? AND password = ? ";

	@Override
	public Employee getInfoById(int id) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery("from Employee where code =: id");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<Employee> getAllInfo() {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public boolean deleteInfo(int id) {
		return jdbcTemplate.update(SQL_Disable_Employee, id) > 0;
	}

	@Override
	public boolean updateInfo(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE,
				employee.getFirstName(), employee.getMiddleName(),
				employee.getLastName(), employee.getDob(),
				employee.getGender(), employee.getEmailId(),
				employee.getContact(), employee.getSkypeId(),
				employee.getProfilePicture(), employee.getCode()) > 0;
	}

	@Override
	public boolean create(Employee employee) {
		// return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,
		// employee.getFirstName(), employee.getMiddleName(),
		// employee.getLastName(), employee.getDob(),
		// employee.getGender(), employee.getEmailId(),
		// employee.getContact(), employee.getSkypeId(),
		// employee.getProfilePicture(), employee.getPassword()) > 0;

		System.out.println("in dao");
		sessionFactory.getCurrentSession().save(employee);
		System.out.println("after query");
		return true;

	}

	public Employee getInfoByEmail(String email) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery("from Employee where email =: email");
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public List<Employee> getInfoByName(String name) {
		return jdbcTemplate.query(SQL_GET_EMPLOYEE_BY_NAME,
				new Object[] { name }, new EmployeeMapper());
	}

	public List<Employee> getInfoByProject(String project) {
		return jdbcTemplate.query(SQL_GET_EMPLOYEE_BY_PROJECT,
				new Object[] { project }, new EmployeeMapper());
	}

	public List<Employee> getInfoBySkills(String skills) {
		return jdbcTemplate.query(SQL_GET_EMPLOYEE_BY_SKILLS,
				new Object[] { skills }, new EmployeeMapper());
	}

	public List<Employee> getInfoByExperience(String experience) {
		return jdbcTemplate.query(SQL_GET_EMPLOYEE_BY_EXPERIENCE,
				new Object[] { experience }, new EmployeeMapper());
	}

	public boolean resetPassword(String email, String oldPassword,
			String newPassword) {
		return jdbcTemplate.update(SQL_UPDATE_PASSWORD, newPassword, email,
				oldPassword) > 0;
	}

}
