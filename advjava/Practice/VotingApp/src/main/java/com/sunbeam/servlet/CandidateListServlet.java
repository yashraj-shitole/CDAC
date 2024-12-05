package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entity.Candidate;


@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);

	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list=new ArrayList<>();
		
		try(CandidateDao candDao=new CandidateDaoImpl()){
			list =candDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");
		
		// get app title from ctx param and display it
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>", appTitle);
				
		
		Cookie[] arr = req.getCookies();
		String userName = "", role = "";
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"))
					userName = c.getValue();
				if(c.getName().equals("role"))
					role = c.getValue();
			}
		}
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		// get servlet context and retrieve announcement from it and display
				ServletContext ctx = this.getServletContext();
				String ann = (String) ctx.getAttribute("announcement");
				if(ann != null)
					out.println("<p style='color:red'> NOTE: " + ann + "</p>");
				
		out.println("<h2>Candidate List</h2>");
		out.println("<form method='post' action='vote'>");
		
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th></th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		
		for(Candidate c : list) {
			
			out.println("<tr>");
			out.printf("<td><input type='radio' name='candidate' value='%d'/></td>\n", c.getId());
			out.printf("<td>%s</td>\n", c.getName());
			out.printf("<td>%s</td>\n", c.getParty());
			out.println("</tr>");
		}
		
		String color=app.getInitParameter("app.color");
		out.println("<body style='background-color:"+color+";'>");
		out.println("</table>");
		
		out.println("<br/><input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	

}
