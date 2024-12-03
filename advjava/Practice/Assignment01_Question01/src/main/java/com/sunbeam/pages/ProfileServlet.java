package com.sunbeam.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.print("<body style=\" background-color:pink;\">");
		
		out.print("<h1>Name: Yashraj</h1>");
		out.print("<h1>Qualification: B.Tech</h1>");
		out.print("<h1>College: Sharad Institute of Technology College of Engineering</h1>");
		out.print("<h1>Birth Data: 02/09/2002</h1>");
		
		
		out.print("</body>");
		
	}

}
