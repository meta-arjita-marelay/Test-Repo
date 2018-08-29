package com.servlets;

import com.database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeDetails = new ArrayList<Employee>();
		try {
			employeeDetails = QueryService.showEmployee();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<table>");
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
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
