package com.sunbeam.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formInfo")
public class ShowInfo extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		processRequest(req, res);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		processRequest(req, res);
		
	}
	
	
	
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServerException, IOException{
		String user= req.getParameter("userName");
		String course=req.getParameter("course");
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
//		NAVBAR
		out.println("<div style=\"background-color: #383838; color: white; padding: 10px; border-radius: 100px; display: flex; align-items: center; justify-content: space-between;\">\r\n"
				+ "		<h1>APP 1</h1>\r\n"
				+ "		<div>\r\n"
				+ "			<a style=\"color: white; padding: 10px;\" href=\"/app1/\">Home</a>		\r\n"
				+ "			<a style=\"color: white; padding: 10px;\" href=\"/app1/about.html\">About</a>		\r\n"
				+ "			<a style=\"color: white; padding: 10px;\" href=\"/app1/contactUs\">Contact</a>		\r\n"
				+ "		</div>\r\n"
				+ "		\r\n"
				+ "	</div>");
		
		out.print("<h3>Form submitted successfully</h3>");
		out.print("<h1>"+user+"</h1>");
		out.print("<h1>"+course+"</h1>");
		
		
				
				
	}
	
	

}
