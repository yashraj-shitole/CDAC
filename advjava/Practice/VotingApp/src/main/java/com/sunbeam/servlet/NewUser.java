package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entity.User;


@WebServlet("/signup")
public class NewUser extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String conPassword=req.getParameter("conPassword");
		
		String date=req.getParameter("date");
		
		Date dob=Date.valueOf(date);
		
		String role="voter";
		int status=0;
		
		User u=new User(0, firstName, lastName, email, password, dob, status, role);
		
		try(UserDao userDao=new UserDaoImpl()){
			
			int count= userDao.save(u);
			
			resp.setContentType("text/html");
			
			PrintWriter out=resp.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Signup</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Registration successful</h2>");
			out.println("<p><a href='index.html'>Login</a></p>");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
