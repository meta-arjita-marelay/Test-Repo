package Controller.servlets;

import Model.pojos.*;
import java.io.IOException;
import java.io.PrintWriter;
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
		String dob = request.getParameter("dob");
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
		userDetails.setOrgName(orgName);
		
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
