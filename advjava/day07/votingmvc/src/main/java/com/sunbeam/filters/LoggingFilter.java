/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Dec 6, 2024
 */

package com.sunbeam.filters;

import java.io.Console;
import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoggingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request; 
		// pre-processing
		System.out.println("Before: Current Time: " + new Date() + " => " + req.getRequestURI());
		// call next component
		chain.doFilter(request, response);
		// post-processing
		System.out.println("After: Current Time: " + new Date() + " => " + req.getRequestURI());
	}
}
