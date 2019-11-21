package com.ustglobal.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookie	=req.getCookies();
		PrintWriter out=resp.getWriter();
		if(cookie==null) {
			out.println("<h1>no cookie found</h1>");
		}else {
			for (Cookie cookie2 : cookie) {
				String name=cookie2.getName();
				if(name.equals("empname")) {
					out.println("<h1>emp name value is");
					out.println(cookie2.getValue());
					out.println("<h1>");
				}
			}
			
		}
	}
}
