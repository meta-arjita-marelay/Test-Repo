package com.servlets;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.SQLException;

import com.database.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		int age = (Integer.parseInt(request.getParameter("age")));
		
		Employee employee= new Employee();
		employee.setFname(fname);
		employee.setLname(lname);
		employee.setEmail(email);
		employee.setAge(age);
		try {
			QueryService.insertEmployee(employee);
			out.println("Added successfully");
			
			
		} catch (SQLException e) {
			out.println(e);
		}
		out.println("<!DOCTYPE html><html><head><link href='style.css' rel=stylesheet></head>"
				+ "<body>");
		out.println("<a href = 'http://localhost:8080/EAD-Assignment-3/' id='backlink'>Back</a> ");
		out.println("</html></body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
