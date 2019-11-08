package com.hwb.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    
    public static void main(String[] args) {

        
        Connection c = null;
        Statement s = null;
        //初始化驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载数据库驱动成功");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "password");
            s = c.createStatement();
            
            //插入数据
            for (int i = 0; i < 100; i++) {
                String insert_sql = "insert into hero values(null," + "'英雄"+i+"'"  + "," + 313.0f + "," + 50 + ")";
                s.execute(insert_sql);
            }
            
            //删除数据
            String delete_sql = "delete from hero where id = 5";
            s.execute(delete_sql);  
            
            //更新数据
            String update_sql = "update hero set name = 'name 5' where id = 3";
            s.execute(update_sql);
            
            //查询数据
            String select_sql = "select * from hero";
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(select_sql);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();
                                    
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
}
