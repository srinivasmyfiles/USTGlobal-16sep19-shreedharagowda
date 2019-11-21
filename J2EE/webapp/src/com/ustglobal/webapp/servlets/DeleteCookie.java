package com.ustglobal.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookie extends HttpServlet {
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
					cookie2.setMaxAge(0);
					out.println("<h1>deleted</h1>");
					resp.addCookie(cookie2);
				}
			}
			
		}

	}
}
