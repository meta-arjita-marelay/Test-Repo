package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.dao.DAOInterface;
import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImplement implements ServiceInterface<Employee> {

	@Autowired
	private DAOInterface<Employee> employeeDAO;

	@Override
	public Employee getInfoById(int id) {
		return employeeDAO.getInfoById(id);
	}

	@Override
	public List<Employee> getAllInfo() {
		return employeeDAO.getAllInfo();
	}

	@Override
	public boolean deleteInfo(int id) {
		return employeeDAO.deleteInfo(id);
	}

	@Override
	public boolean updateInfo(Employee employee) {
		return employeeDAO.updateInfo(employee);
	}

	@Override
	public boolean create(Employee employee) {
		// Employee employeeDetail = getInfoByEmail(employee.getEmailId());
		// System.out.println(employeeDetail.getEmailId());
		// if
		// (employeeDetail.getEmailId().equalsIgnoreCase(employee.getEmailId()))
		// {
		// return false;
		// }
		return employeeDAO.create(employee);
	}

	public Employee getInfoByEmail(String email) {
		return ((EmployeeDAO) employeeDAO).getInfoByEmail(email);
	}

	public List<Employee> searchBy(String filter, String attributeName) {
		if (filter.equals("name")) {
			return ((EmployeeDAO) employeeDAO).getInfoByName(attributeName);
		} else if (filter.equals("project")) {
			return ((EmployeeDAO) employeeDAO).getInfoByProject(attributeName);
		} else if (filter.equals("skills")) {
			return ((EmployeeDAO) employeeDAO).getInfoBySkills(attributeName);
		} else {
			return ((EmployeeDAO) employeeDAO)
					.getInfoByExperience(attributeName);
		}
	}

	public Boolean validateLogin(String email, String password) {
		Employee employee = getInfoByEmail(email);
		if (employee.getEmailId().equalsIgnoreCase(email)
				&& employee.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public Boolean resetPassword(String email, String oldPassword,
			String newPassword) {

		return ((EmployeeDAO) employeeDAO).resetPassword(email, oldPassword,
				newPassword);

	}
}
