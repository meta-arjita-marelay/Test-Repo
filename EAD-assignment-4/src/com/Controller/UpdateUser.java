package com.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.UserDetails;

import com.dao.UserService;
import com.enums.Status;
import com.facade.UserFacade;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		PrintWriter out = response.getWriter();
		UserDetails user = new UserDetails();
		user.setFirstName(fname);
		user.setLastname(lname);
		user.setConNumber(contact);
		user.setEmailId(email);
		Status check=UserFacade.updateUser(user);
		request.getRequestDispatcher("Profile").include(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
