package com.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.enums.Status;
import com.facade.UserFacade;

/**
 * Servlet Filter implementation class IsLoginValid
 */
public class IsLoginValid implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		System.out.println("filter email"+email);
		try {
			if (Status.VALID.equals(UserFacade.checkLoginValidity(email,
					password))) {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				HttpSession session = httpRequest.getSession();
				session.setAttribute("id", email);
				chain.doFilter(request, response);
			}
		} catch (SQLException e) {
			out.print("INVALID LOGIN");
			request.getRequestDispatcher("Login.html").include(request,
					response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
