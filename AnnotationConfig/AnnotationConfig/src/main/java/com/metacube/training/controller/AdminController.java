package com.metacube.training.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		return new ModelAndView("admin/dashboard");
		//return new ModelAndView("admin/dashboard", "username", username);
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String addProject() {

		return "admin/project";
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ModelAndView project(
			@RequestParam("description") String description,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("logo") MultipartFile logo) {

		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String addSkill() {

		return "admin/skills";
	}

	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public ModelAndView addSkill(@RequestParam("skillName") String skillName) {

		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle() {

		return "admin/jobTitle";
	}

	@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public ModelAndView addJobTitle(@RequestParam("jobTitle") String jobTitle) {

		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee() {
System.out.println("jjjj");
		return "admin/addEmployee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(
			@RequestParam("fname") String firstName,
			@RequestParam("mname") String middleName,
			@RequestParam("lname") String lastName,
			@RequestParam("email") String email,
			@RequestParam("dob") String dob,
			@RequestParam("gender") String gender,
			@RequestParam("doj") String doj,
			@RequestParam("reportingMgr") int reportingMgr,
			@RequestParam("teamLead") int teamLead,
			@RequestParam("projectId") int projectId) {
			
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee() {

		return "admin/searchEmployee";
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(
			@RequestParam("employeeName") String employeeName) {

		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {

		return "home";
	}
}
