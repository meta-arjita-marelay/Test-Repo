package com.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.Employee;
import com.database.QueryService;

public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeDetails = new ArrayList<Employee>();
		PrintWriter out = response.getWriter();
		try {
			String name = request.getParameter("name");
			employeeDetails = QueryService.searchEmployee(name);
			out.println("<!DOCTYPE html><html><head><link href='style.css' rel=stylesheet></head><body>");
			out.println("<table border='5px solid black' cellpadding='5px'>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Age</th>");
			out.println("</tr>");
			for (Employee employee : employeeDetails) {
				String fname = employee.getFname();
				String lname = employee.getLname();
				String email = employee.getEmail();
				int age = employee.getAge();
				out.println("<tr><td>" + fname + "</td><td>" + lname
						+ "</td><td>" + email + "</td><td>" + age + "</td>");
			}
			out.println("</table>");
			out.println("</body></html>");
		} catch (SQLException e) {
			out.println(e);
		}
		out.println("<!DOCTYPE html><html><head><link href='style.css' rel=stylesheet></head><body>");
		out.println("<a href = 'http://localhost:8080/EAD-Assignment-3/' id='backlink'>Back</a>");
		out.println("</html></body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
