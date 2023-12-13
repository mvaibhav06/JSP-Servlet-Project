package com.app.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.app.registration.model.Employee;

public class EmployeeDao {

	public int registerEmployee(Employee employee) {
		
		String INSERT_USERS_SQL = "insert into employee values " + "(?,?,?,?,?,?,?);";
		
		int result = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
			PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL);
			ps.setInt(1, 3);
			ps.setString(2, employee.getFirst_name());
			ps.setString(3, employee.getLast_name());
			ps.setString(4, employee.getUser_name());
			ps.setString(5, employee.getPassword());
			ps.setString(6, employee.getAddress());
			ps.setString(7, employee.getContact());
			
			System.out.println(ps);
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
}
