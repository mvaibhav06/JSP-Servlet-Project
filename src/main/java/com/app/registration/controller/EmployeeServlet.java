package com.app.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.app.registration.dao.EmployeeDao;
import com.app.registration.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String first_name = req.getParameter("firstName");
		String last_name = req.getParameter("lastName");
		String user_name = req.getParameter("userName");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");
		
		Employee employee = new Employee(first_name, last_name, user_name, password, address, contact);
		EmployeeDao employeeDao = new EmployeeDao();
		int result = employeeDao.registerEmployee(employee);
		
//		RequestDispatcher rd = req.getRequestDispatcher("/views/employeedetails.jsp");
//		rd.forward(req, resp);
//		PrintWriter out = resp.getWriter();
//		
//		resp.setContentType("text/html");
//		out.print("<h3 style='color:green'>User registered successfully</h3>");
		RequestDispatcher rd = req.getRequestDispatcher("/views/employeedetails.jsp");
		rd.include(req, resp);
	}
	
	
}
