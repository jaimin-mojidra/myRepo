package com.dbQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.LoginBean;

public class GetString {
	Connection con = null;
	public GetString(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:jaimin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUserTypeString(String username, String password){
		String str = null;
		if(con==null){
			try {
				throw new SQLException("Can't get database connection");
			} catch (SQLException e) {
				e.printStackTrace();
				return "error";
			}
		}
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			ps = con.prepareStatement("select usertype from user where username = \'"+ username +"\' and password = \'" + password + "\';");			
			result =  ps.executeQuery();
			String usertype = "failed";
			while(result.next()){
				usertype = result.getString("usertype");			
			}
			return usertype;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}
}