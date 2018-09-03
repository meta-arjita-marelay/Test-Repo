package com.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.UserFacade;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String emailId = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		try {
			Status check = UserFacade.checkLoginValidity(emailId, pwd);
			if (Status.VALID.equals(check)) {
				request.getRequestDispatcher("Profile").forward(request,
						response);
			}
			else{
				out.print("INVALID LOGIN");
				request.getRequestDispatcher("Login.html").include(request,
						response);
			}
		} catch (SQLException e) {
			System.out.println(e);	
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
