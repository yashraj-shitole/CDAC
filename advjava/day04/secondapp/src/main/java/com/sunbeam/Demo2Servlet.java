/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Dec 3, 2024
 */

package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2Servlet extends HttpServlet {
	private Connection con;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Demo2Servlet.doGet() called.");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Demo1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Information</h1>");
		int id = Integer.parseInt(req.getParameter("userId"));
		String sql = "SELECT * FROM users WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String email = rs.getString("email");
					out.printf("<h3>Name: %s %s</h3>\n", firstName, lastName);
					out.printf("<h3>Email: %s</h3>", email);
				}
				else {
					out.println("<h3>User Not Found</h3>");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Demo2Servlet.init() called.");
		
		String dbDriver = config.getInitParameter("jdbc.driver");
		String dbUrl = config.getInitParameter("jdbc.url");
		String dbUser = config.getInitParameter("jdbc.user");
		String dbPassword = config.getInitParameter("jdbc.password");
		
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	
	}
	@Override
	public void destroy() {
		System.out.println("Demo2Servlet.destroy() called.");
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
