package com.dbQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.devteambeans.BuildRequestBean;

public class DataInsertionClass<BuildRequestBean> {
	Connection con = null;
	public DataInsertionClass(){
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
	public String insertBuildRequest(BuildRequestBean bean){
		String environment = ((com.devteambeans.BuildRequestBean) bean).getSelectedEnv();
		String team = ((com.devteambeans.BuildRequestBean) bean).getSelectedTeam();
		String type = ((com.devteambeans.BuildRequestBean) bean).getRequesttype();
		String date = ((com.devteambeans.BuildRequestBean) bean).getRequestdate();
		String time = ((com.devteambeans.BuildRequestBean) bean).getRequesttime();
		String requirements = ((com.devteambeans.BuildRequestBean) bean).getRequirements();
		String defects = ((com.devteambeans.BuildRequestBean) bean).getDefects();		
		String remarks = ((com.devteambeans.BuildRequestBean) bean).getRemarks();
		String reqname = ((com.devteambeans.BuildRequestBean) bean).getReqname();
		
		if(con==null)
			try {
				throw new SQLException("Can't get database connection");
			} catch (SQLException e) {
				e.printStackTrace();
				return "error";
			}
 
		try {
			String sql = "insert into buildrequests (team, environment, type, reqdate, reqtime, requirements, defects, remarks, reqname) values('"+ team
					+"','"+ environment +"','"+ type +"','"+ date +"','"+ time +"','"+ requirements +"','"+ defects +"','"+ remarks +"','"+ reqname +"');";
			/*String sql = "insert into buildrequests (team, environment, type, reqdate, reqtime) values('"
					+ team + "','" + environment + "','" + type + "','"+ date +"');";*/
			System.out.println("sql " + sql);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Done");
		} catch (SQLException e) {
			e.printStackTrace();			
			return "error";
		}finally{
			try{
		        if(con!=null)
		            con.close();
		    }catch(SQLException se){
		    	se.printStackTrace();
		        return "error";
		    }
		}
		return "success";
	}
}