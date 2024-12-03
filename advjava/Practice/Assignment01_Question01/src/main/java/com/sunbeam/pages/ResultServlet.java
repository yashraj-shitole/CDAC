package com.sunbeam.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.security.auth.Subject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

	ArrayList<SubjectMarks> result;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		
		super.init(config);
		result=new ArrayList<SubjectMarks>();
		
		result.add(new SubjectMarks("Java programming",80.0));
		result.add(new SubjectMarks("Web Programming",85.0));
		result.add(new SubjectMarks("Database technologies",83.0));
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		out.println("<table>");
		out.println("<tr>");
			out.println("<th>Subject</th>");
			out.println("<th>Marks</th>");
			
		out.println("</tr>");
		for(SubjectMarks m:result) {
			
			out.println("<tr>");
			out.println("<td>"+m.getSubject()+"</td>");
			out.println("<td>"+m.getMarks()+"</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		
		
	}
}
