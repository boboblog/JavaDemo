package com.hwb.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	 
	        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
	                "root", "password");
	                Statement s = c.createStatement();
	                 
	                ) {
	            String name = "root";
	            String password = "root";
	   
	            String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
	              
	            // 执行查询，并把结果集返回ResultSet
	            ResultSet rs = s.executeQuery(sql);
	              
	            if(rs.next())
	                System.out.println("账号密码正确");
	            else
	                System.out.println("账号密码错误");
	             
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	}

}
