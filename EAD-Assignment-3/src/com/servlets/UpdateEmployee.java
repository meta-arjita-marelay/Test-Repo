package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.Employee;
import com.database.QueryService;


public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		String oldemail=request.getParameter("oldemail");
		PrintWriter out = response.getWriter();
		try{
			/*out.println(lname);*/
			Employee employee = new Employee();
			employee.setFname(fname);
			employee.setLname(lname);
			employee.setEmail(email);
			employee.setAge(age);
			QueryService.updateEmployee(employee, oldemail);
			request.getRequestDispatcher("ShowEmployeeServlet").include(request, response);
		}
		catch(SQLException e){
			out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
