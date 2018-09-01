package com.Controller;

import com.Model.UserDetails;
import com.enums.Status;
import com.facade.UserFacade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String emailId = request.getParameter("email");
		Date dob = null;
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse( request.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String userPassword= request.getParameter("pwd");
		String conNumber = request.getParameter("cnumber");
		String orgName = request.getParameter("orgname");
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(firstName);
		userDetails.setLastname(lastName);
		userDetails.setEmailId(emailId);
		userDetails.setDob(dob);
		userDetails.setUserPassword(userPassword);
		userDetails.setConNumber(conNumber);
		System.out.println(orgName);
		System.out.println(dob);
		Status check = UserFacade.addUser(userDetails);
		System.out.println(check);
		if(Status.SUCCESS.equals(check)){
			request.getRequestDispatcher("Login.html").forward(request, response);
		}
		else if(Status.DUPLICATE.equals(check)){
			response.setContentType("text/html");
			out.println("<html><head><script>");
			out.println("alert('this email id already exists.')");
			out.println("</script></head></html>");
			request.getRequestDispatcher("SignUp.html").include(request, response);
		}
		else if(Status.FAIL.equals(check)){
			response.setContentType("text/html");
			out.println("<html><body>");
			out.println("alert('There is some error. Please contact admin')");
			out.println("</html></body>");
			request.getRequestDispatcher("SignUp.html").include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
