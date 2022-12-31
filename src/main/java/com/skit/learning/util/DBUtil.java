package com.skit.learning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static void readeData(){
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/dec_8pm","mover","mysqlpwd");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from student");  
			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  
	
	public static Connection getConnection(){
		Connection con=null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/dec_8pm","mover","mysqlpwd");  
			//here sonoo is database name, root is username and password  
			 
		}catch(Exception e){ 
			System.out.println(e);
		}  
		
		return con;
	}  
	
	public static Statement getStatement(){
		Statement statement=null;
		Connection con;
		try{  
			con = getConnection();
			statement=con.createStatement();  
			 
		}catch(Exception e){ 
			System.out.println(e);
		}  
		
		return statement;
	}  
	
	public static void closeConnection(Connection con, Statement st) {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
