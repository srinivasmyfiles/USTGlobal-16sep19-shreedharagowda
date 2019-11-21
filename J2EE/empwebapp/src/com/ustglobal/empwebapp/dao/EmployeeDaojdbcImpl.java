package com.ustglobal.empwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ustglobal.empwebapp.dto.EmployeeInfo;

public class EmployeeDaojdbcImpl implements EmployeeDAO {
	//Database Connection url
	private static final String URL="jdbc:mysql://localhost:3306/ust_ty_web_db?user=root&password=";
	private static final String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
	//Query
	private static final String SELECT_SQL="select * from employee_db where id=?";
	private static final String INSERT_SQL="insert into employee_db values(?,?,?,?)";
	private static final String UPDATE_SQL="update employee_db set password=? where id=?";

	@Override
	public EmployeeInfo auth(int id, String password) {
		//		String sql="select * from employee_db where id=? and password=?";

		EmployeeInfo info=searchEmployee(id);
		if(info!=null) {
			String pass=info.getPassword();
			if(pass.equals(password)) {
				return info;
			}else {
				return null;
			}
		}
		return null;
	}

	@Override
	public EmployeeInfo searchEmployee(int id) {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			try(Connection con=DriverManager.getConnection(URL);
					PreparedStatement pst=con.prepareStatement(SELECT_SQL)){
				pst.setInt(1, id);
				try(ResultSet rs=pst.executeQuery()){
					if(rs.next()) {
						EmployeeInfo info=new EmployeeInfo();
						info.setId(rs.getInt("id"));
						info.setName(rs.getString("name"));
						info.setEmail(rs.getString("email"));
						info.setPassword(rs.getString("password"));

						return info;
					}else {
						return null;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean changePassword(int id, String password) {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			try(Connection con=DriverManager.getConnection(URL);
					PreparedStatement pst=con.prepareStatement(UPDATE_SQL)){

				pst.setString(1, password);
				pst.setInt(2, id);

				int count=pst.executeUpdate();

				boolean check=count>0?true:false;
				return check;
				//				if(count>0) {
				//					return true;
				//				}else {
				//					return false;
				//				}

			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}//end change password

	@Override
	public boolean registerEmployee(EmployeeInfo info) {
		try{
			Class.forName(DRIVER_CLASS_NAME);
			try(Connection con=DriverManager.getConnection(URL);
					PreparedStatement pstmt=con.prepareStatement(INSERT_SQL)){

				pstmt.setInt(1, info.getId());
				pstmt.setString(2, info.getName());
				pstmt.setString(3, info.getEmail());
				pstmt.setString(4, info.getPassword());

				int count = pstmt.executeUpdate();
				if(count>0) {
					return true;
				}else {
					return false;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}//end register method
}//end class
