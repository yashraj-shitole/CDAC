package com.sunbeam.servlet;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entity.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get selected candidate id from previous page
		String candId = req.getParameter("candidate"); // "candidate" is name of radio button in prev page
		int id = Integer.parseInt(candId);
		// increment votes of that candidate in database
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		ServletContext app = this.getServletContext();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		String color=app.getInitParameter("app.color");
		out.println("<body style='background-color:"+color+";'>");
		
		// get app title from ctx param and display it
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
		
		
		out.println("<h2>Voting Status</h2>");
		
		// retrieve current user from session
				HttpSession session = req.getSession(false);
				if(session == null) {
					resp.sendError(440);
					return;
				}
				
				User user = (User) session.getAttribute("curUser");
				// let user vote, if not already voted
				if(user.getStatus() == 0) {
					try(CandidateDao candDao = new CandidateDaoImpl()) {
						int count = candDao.incrVote(id);
						if(count == 1) {
							out.println("<h4>You have successfully casted your vote.</h4>");
							// after voting, update user status in database
							user.setStatus(1);
							try(UserDao userDao = new UserDaoImpl()) {
								count = userDao.update(user);
								if(count == 1)
									out.println("<h4>You are marked as voted.</h4>");
							}
						} else
							out.println("<h4>Your voting failed.</h4>");
					}	
					catch (Exception e) {
						e.printStackTrace();
						throw new ServletException(e);
					}
				}
				else {
					out.println("<h4>You have already voted.</h4>");
				}
		
		
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
