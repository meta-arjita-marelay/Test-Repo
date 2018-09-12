package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;
import com.metacube.training.model.SkillsMaster;
import com.metacube.training.service.EmployeeServiceImplement;
import com.metacube.training.service.ServiceInterface;

/**
 * Controller class to perform various operations of admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ServiceInterface<Employee> employeeService;

	@Autowired
	ServiceInterface<Project> projectService;
/*
	@Autowired
	ServiceInterface<JobTitle> jobTitleService;*/

	@Autowired
	ServiceInterface<SkillsMaster> skillService;

	/**
	 * method to redirect to dashboard
	 * 
	 * @return destination path
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "admin/dashboard";
	}

	/**
	 * method to move to login page
	 * 
	 * @return destination path
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * Function to validate email and paassword of admin and redirect to
	 * dashboard page
	 * 
	 * @param email
	 *            email entered by user
	 * @param password
	 *            password entered by user
	 * @param model
	 *            will be used in error message
	 * @return destination path
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {
		if (email.equalsIgnoreCase("arjita@gmail.com")
				&& password.equals("123456")) {
			return "admin/dashboard";
		}
		model.addAttribute("error", "error");
		return "admin/login";
	}

	/**
	 * Function to redirect to Add Employee page
	 * 
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String adminAddEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/addEmployee";
	}

	/**
	 * method to Add new Employee or update employee details
	 * 
	 * @param employee
	 *            which is to be added or updated
	 * @param model
	 *            will be used for error message
	 * @return link to redirect to another page
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public String adminAddEmployee(
			@ModelAttribute("employee") Employee employee, Model model) {
		Boolean status = false;
		if (employee != null && employee.getCode() == 0) {
			status = employeeService.create(employee);
		} else {
			employeeService.updateInfo(employee);
		}
		if (status) {
			return "admin/dashboard";
		}
		model.addAttribute("error", "error");
		return "admin/addEmployee";

	}

	/**
	 * method to redirect to show employee page
	 * 
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/showEmployee", method = RequestMethod.GET)
	public String showEmployee(Model model) {
		model.addAttribute("employees", employeeService.getAllInfo());
		return "admin/showEmployee";
	}

	/**
	 * method to edit the details of the employee
	 * 
	 * @param model
	 * @param code
	 * @return
	 */
	@RequestMapping(path = "/showEmployee/edit", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") int code) {
		model.addAttribute("employee", employeeService.getInfoById(code));
		return "admin/addEmployee";
	}

	/**
	 * method to disable the employee
	 * 
	 * @param code
	 * @return link to redirect
	 */
	@RequestMapping(path = "/showEmployee/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int code) {
		employeeService.deleteInfo(code);
		return "redirect:/admin/showEmployee";
	}

	/**
	 * method to redirect to add project page
	 * 
	 * @param model
	 * @return link to add project page
	 */
	@RequestMapping(value = "/addProjects", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/addProjects";
	}

	/**
	 * method to add new project
	 * 
	 * @param projectMaster
	 * @return
	 */
	@RequestMapping(value = "/addProjects", method = RequestMethod.POST)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public String addProject(
			@ModelAttribute("project") Project projectMaster) {

		if (projectMaster != null && projectMaster.getId() == 0) {
			projectService.create(projectMaster);
		} else {
			projectService.updateInfo(projectMaster);
		}
		return "admin/dashboard";
	}

	/**
	 * method to redirect to show project page
	 * 
	 * @param model
	 * @return link to show project page
	 */
	@RequestMapping(path = "/showProject", method = RequestMethod.GET)
	public String showProjects(Model model) {
		model.addAttribute("projects", projectService.getAllInfo());
		return "admin/showProject";
	}

	/**
	 * method to edit the project
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/showProject/edit", method = RequestMethod.GET)
	public String editProject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getInfoById(id));
		return "/admin/addProjects";
	}

	/**
	 * method to delete the project
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/showProject/delete", method = RequestMethod.GET)
	public String deleteProject(@RequestParam("id") int id) {
		projectService.deleteInfo(id);
		return "redirect:/admin/showProject";
	}

	/**
	 * method to redirect to add skills page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addSkills", method = RequestMethod.GET)
	public String addSkill(Model model) {
		model.addAttribute("skills", new SkillsMaster());
		return "admin/skills";
	}

	/**
	 * method to add new skill
	 * 
	 * @param skillsMaster
	 * @return
	 */
	@RequestMapping(value = "/addSkills", method = RequestMethod.POST)
	public ModelAndView addSkill(
			@ModelAttribute("skills") SkillsMaster skillsMaster) {
		System.out.println(skillService.create(skillsMaster));
		return new ModelAndView("admin/dashboard");
	}

	/**
	 * method to redirect to job title page
	 * 
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle(Model model) {
		model.addAttribute("jobTitle1", new JobTitle());
		return "admin/jobTitle";
	}*/

	/**
	 * Function to add new job title
	 * 
	 * @param jobTitle
	 * @return
	 */
	/*@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public ModelAndView addJobTitle(
			@ModelAttribute("jobTitle1") JobTitle jobTitle) {
		jobTitleService.create(jobTitle);
		return new ModelAndView("admin/dashboard");
	}*/

	/**
	 * method to move to search employee page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(@RequestParam("role") int role, Model model) {
		model.addAttribute("role", role);
		return "admin/searchEmployee";
	}

	/**
	 * method to search the employee by name , experience , skills , project
	 * 
	 * @param attributeName
	 * @param searchBy
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public String searchEmployee(
			@RequestParam("attribute") String attributeName,
			@RequestParam("searchBy") String searchBy,
			@RequestParam("role") int role, Model model) {
		model.addAttribute("employees",
				((EmployeeServiceImplement) employeeService).searchBy(searchBy,
						attributeName));
		if (role == 1) {
			return "admin/showEmployee";
		} else
			return "employee/showEmployee";
	}

	/**
	 * method to logout the user
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "admin/login";
	}
}