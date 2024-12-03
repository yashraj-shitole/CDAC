package com.sunbeam.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactUs")
public class ContactUsForm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
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
		
//		FORM
		out.println("<form style=\"flex-direction:column; padding: 10px; border-radius: 25px; display: flex; align-items: center; justify-content: space-between;\" method=\"post\" action=\"formInfo\">\r\n"
				+ "		Name: <input type=\"text\" name=\"userName\"/> <br/><br/>\r\n"
				+ "		Course: \r\n"
				+ "			<select name=\"course\">\r\n"
				+ "				<option value=\"DAC\">PG-DAC</option>\r\n"
				+ "				<option value=\"DMC\">PG-DMC</option>\r\n"
				+ "				<option value=\"DESD\">PG-DESD</option>\r\n"
				+ "				<option value=\"DBDA\">PG-DBDA</option>\r\n"
				+ "				<option value=\"DITISS\">PG-DITISS</option> \r\n"
				+ "			</select>\r\n"
				+ "			<br/><br/>\r\n"
				+ "		<input type=\"submit\" value=\"Submit\"/>\r\n"
				+ "	</form>");
		
		
		
		
		
		
	}
	
	
}
