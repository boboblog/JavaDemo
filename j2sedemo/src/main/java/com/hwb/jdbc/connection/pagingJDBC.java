package com.hwb.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pagingJDBC {
	public static void list(int start, int count) {
		Connection c = null;
	    Statement s = null;
		//初始化驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载数据库驱动成功");
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
	                "root", "password");
			s = c.createStatement();				
	        
	        //分页查询数据
			String sql = "select * from hero limit " +start + "," + count;
	        // 执行查询语句，并把结果集返回给ResultSet
	        ResultSet rs = s.executeQuery(sql);
	        while (rs.next()) {
	            int id = rs.getInt("id");// 可以使用字段名
	            String name = rs.getString(2);// 也可以使用字段的顺序
	            float hp = rs.getFloat("hp");
	            int damage = rs.getInt(4);
	            System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
	        }	                              	
		} catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally {
	        // 数据库的连接是有限资源，相关操作结束后，养成关闭数据库的好习惯
	        // 先关闭Statement
	        if (s != null)
	            try {
	                s.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        // 后关闭Connection
	        if (c != null)
	            try {
	                c.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list(10,5);
	}

}
