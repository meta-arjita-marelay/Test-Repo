package com.Controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.UserDetails;
import com.dao.UserService;

public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String email = (String) session.getAttribute("email");

		System.out.println("profile" + email);
		UserDetails user = UserService.getDetails(email);

		out.print("<html>");
		out.print("<head>");
		out.print("<title>www.html5.com</title>");
		out.print("<link href = 'Stylesheets/style.css' rel = 'stylesheet'>");
		out.print("</head>");
		out.print("<body><table>");
		out.print("<tr><td><img src='logo.png' id='logo' height = 50px></td>");
		out.print("<td align = 'right'><span id = 'username'>"
				+ user.getFirstName() + " " + user.getLastname()
				+ "</span><a href='Friends?email="+user.getEmailId()+"'>Friends</a>"
				+ "<a href = 'Login.html'>Logout</a></td>");
		out.print("</tr></table>");
		out.print("<hr /><br /><br /><h1>Welcome</h1>");
		out.print("<table class='form-style-1'><tr>");
		out.print("<td><p><strong>First Name:</strong></p></td>");
		out.print("<td><p>" + user.getFirstName() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Last Name:</strong></p></td>");
		out.print("<td><p>" + user.getLastname() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Age:</strong></p></td>");
		out.print("<td><p>" + user.getDob() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Email:</strong></p></td>");
		out.print("<td><p>" + user.getEmailId() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Contact Number:</strong></p></td>");
		out.print("<td><p>" + user.getConNumber() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Organization:</strong></p></td>");
		out.print("<td><p>" + user.getOrgName() + "</p></td></tr>");
		out.print("<td><a href='EditUser?email=" + user.getEmailId()
				+ "&fname=" + user.getFirstName() + "&lname="
				+ user.getLastname() + "&contact=" + user.getConNumber()
				+ "'>Edit</a></td></tr>");
		out.print("</table>");
		out.print("<footer id = 'fixfooter'>&copy;Copyright 2017-18 | All Rights Reserved | Metacube Training</footer>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
