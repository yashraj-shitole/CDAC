package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entity.Candidate;

import javax.servlet.http.*;


@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get candidate id from query string
		String candId = req.getParameter("id");
		int id = Integer.parseInt(candId);
		// find candidate in db by id and display details in html form
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit</title>");
		out.println("</head>");
		out.println("<body>");
		// get app title from ctx param and display it
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>", appTitle);
				
		out.println("<h2>Edit Candidate</h2>");
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			Candidate c = candDao.findById(id);
			if(c != null) {
				out.println("<form method='post' action='editcand'>");
				out.printf("<input type='hidden' name='id' value='%d' readonly><br/>\n", c.getId());
				out.printf("Name: <input type='text' name='name' value='%s'><br/>\n", c.getName());
				out.printf("Party: <input type='text' name='party' value='%s'><br/>\n", c.getParty());
				out.printf("Votes: <input type='text' name='votes' value='%d' readonly><br/><br/>\n", c.getVotes());
				out.println("<input type='submit' value='Update Candidate'>");
				out.println("</form>");
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the candidate details from html form (created in get req)
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		int votes = Integer.parseInt(req.getParameter("votes"));
		// update the details in db
		Candidate c = new Candidate(id, name, party, votes);
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.update(c);
			String message = "Candidates updated: " + count;
			req.setAttribute("msg", message);

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		// forward req to result page
		//RequestDispatcher rd = req.getRequestDispatcher("result");
				ServletContext ctx = this.getServletContext();
				RequestDispatcher rd = ctx.getRequestDispatcher("/result");
				rd.forward(req, resp);
	}
	
	
}
