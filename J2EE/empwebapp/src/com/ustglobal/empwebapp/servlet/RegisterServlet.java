package com.ustglobal.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfo;
import com.ustglobal.empwebapp.util.EmployeeDaoManager;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();

		EmployeeInfo info=new EmployeeInfo();

		info.setId(Integer.parseInt(req.getParameter("id")));
		info.setEmail(req.getParameter("email"));
		info.setName(req.getParameter("name"));
		info.setPassword(req.getParameter("password"));
		EmployeeDAO dao=EmployeeDaoManager.getEmployeeDAO();
		boolean user=dao.registerEmployee(info);
		if(user) {
//			out.println("<html>");
//			
//			out.println("<h3 style='color:blue'>Registration Success</h3>");
//			out.println("</html>");
			String msg="Registration Success";
			req.setAttribute("msg", msg);
		}else {
//			out.println("<html>");
//			out.println("<h3 style='color:red'>Change ID</h3>");
//			out.println("</html>");
			String msg1="Dont Repeat ID";
			req.setAttribute("msg1", msg1);
		}
		RequestDispatcher dispatch=req.getRequestDispatcher("./login.jsp");
		dispatch.include(req, resp);
	}
}