/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Dec 6, 2024
 */

package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc")
public class FrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewPath;
		String page = req.getParameter("page");
		if(page.equals("login"))
			viewPath = "/login.jsp";
		else if(page.equals("newuser"))
			viewPath = "/newuser.jsp";
		else if(page.equals("index"))
			viewPath = "/index.jsp";
		else if(page.equals("result"))
			viewPath = "/WEB-INF/views/result2.jsp";
		else if(page.equals("candlist"))
			viewPath = "/WEB-INF/views/candlist.jsp";
		else if(page.equals("logout"))
			viewPath = "/WEB-INF/views/logout.jsp";
		else if(page.equals("editcand"))
			viewPath = "/WEB-INF/views/editcand.jsp";
		else if(page.equals("delcand"))
			viewPath = "/WEB-INF/views/delcand.jsp";
		else if(page.equals("updatecand"))
			viewPath = "/WEB-INF/views/updatecand.jsp";
		else if(page.equals("vote"))
			viewPath = "/WEB-INF/views/vote.jsp";
		else
			viewPath = "/index.jsp";
		ServletContext ctx = this.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher(viewPath);
		rd.forward(req, resp);
	}
}
