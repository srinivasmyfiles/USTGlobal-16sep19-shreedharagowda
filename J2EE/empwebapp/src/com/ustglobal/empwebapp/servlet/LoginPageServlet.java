package com.ustglobal.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.html")
public class LoginPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();

		String id="";
		Cookie[] cookies=req.getCookies();
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("alwaysremember")) {
					id=cookie.getValue();
				}	
			}
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='./login' method='post' style='width: 200px; height: 400px; margin-top: 100px; margin-left: 500px'>");
		out.println("<h3 style='color: red'>Login Here</h3>");
		out.println(" name :<input type='text' name='id' value='"+id+"'placeholder='Enter UserID'><br><br>");
		out.println("password:<input type='password' name='password' placeholder='Enter Password'> <br>");
		out.println("<input style='margin-left: 50px' type='checkbox' value='checked' name='remember'>Remember Me");
		out.println("<br> <input type='submit' name='submit' value='Login' style='color: blue;'><br>");
		out.println("<br> <a style='float: left' href='register.html'>Register</a>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
