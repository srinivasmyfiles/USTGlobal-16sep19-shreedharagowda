package com.ustglobal.webapp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmpSearch extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/ust_global?user=root&password=";
		int id=Integer.parseInt(req.getParameter("id"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		String sql="select * from Employee_Info where id=?";
		ResultSet rs=null;
		PrintWriter out=resp.getWriter();
		try(Connection con=DriverManager.getConnection(url);
			PreparedStatement pst=con.prepareStatement(sql)){
			
			pst.setInt(1, id);
			rs=pst.executeQuery();
			out.println("<html>");
			out.println("<body>");
			out.println("<table border=2>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Salary</th>");
			out.println("<th>Gender</th>");
			out.println("</tr>");
			if(rs.next()) {
				out.println("<tr>");

				
				out.println("<td>"+rs.getInt("id")+"</td>");
				out.println("<td>"+rs.getString("name")+"</td>");
				out.println("<td>"+rs.getInt("sal")+"</td>");
				out.println("<td>"+rs.getString("gender")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
