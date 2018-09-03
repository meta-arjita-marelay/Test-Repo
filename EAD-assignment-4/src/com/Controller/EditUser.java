package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUser
 */

public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String oldemail = request.getParameter("email");
		String oldfname = request.getParameter("fname");
		String oldlname = request.getParameter("lname");
		String oldcontact = request.getParameter("contact");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE html><html><head><link href='style.css' "
				+ "rel=stylesheet></head><body>");
		out.println("<form action = 'UpdateUser' name = 'form1'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>First Name</td><td>");
		out.println("<input type='text' name='fname' id='fname' value='"
				+ oldfname + " required'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Last Name</td><td>");
		out.println("<input type='text' name='lname' id='lname' value='"
				+ oldlname + " required'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Age</td><td>");
		out.println("<input type='text' name='contact' id='age' value='"
				+ oldcontact + " required'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type='hidden' name='oldemail' id='fname' "
				+ "value='" + oldemail + "' ></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td><input type='submit' id='update' value='update details'");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
