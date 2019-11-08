package com.hwb.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hwb.pojo.Category;
import com.hwb.pojo.Order;
import com.hwb.pojo.OrderItem;
import com.hwb.pojo.Product;

public class TestMybatis {
	
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
//		Category c = new Category();
//      c.setName("新增加的Category");
//      session.insert("addCategory",c);
//		c.setId(6);
//		session.delete("deleteCategory",c);
//		Category c = session.selectOne("getCategory", 3);
//		c.setName("修改名称");
//		session.update("updateCategory",c);
//      listAll(session);
//		List<Category> cs = session.selectList("listCategoryByName","1");

//      Map<String, Object> params = new HashMap<>();
//      params.put("id", 3);
//      params.put("name", "cat");
//      List<Category> cs = session.selectList("listCategoryByIdAndName",params);
//	    for (Category c : cs) {
//	    	System.out.println(c.getName());
//	    }
		
//		List<Category> cs = session.selectList("listCategoryP");
//		for(Category c : cs) {
//			System.out.println(c);
//			List<Product> ps = c.getProducts();
//			for(Product p : ps) {
//				System.out.println("\t" + p);
//			}
//		}
		
//		List<Product> ps = session.selectList("listProduct1");
//		for(Product p : ps) {
//			System.out.println(p +" 对应的分类是 \t "+ p.getCategory());
//		}
//		deleteOrderItem(session);
//		addOrderItem(session);
//		listOrder(session);
		
//		System.out.println("查询所有的");
//        List<Product> ps = session.selectList("listProduct2");
//        for (Product p : ps) {
//            System.out.println(p);
//        }
//         
//        System.out.println("模糊查询");
//        Map<String,Object> params = new HashMap<>();
//        params.put("name","a");
//        List<Product> ps2 = session.selectList("listProduct2",params);
//        for (Product p : ps2) {
//            System.out.println(p);
//        } 
		
//		System.out.println("多条件查询");
//		Map<String,Object> params = new HashMap<>();
//		params.put("price","10");
//		List<Product> ps2 = session.selectList("listProduct3",params);
//		for (Product p : ps2) {
//            System.out.println(p);
//        }  
		
//		Map<String,Object> params = new HashMap<>();
//		params.put("name","a");
//		params.put("price","10");
//		List<Product> ps = session.selectList("listProduct4",params);
//		for (Product p : ps) {
//			System.out.println(p);
//		}
		
		List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
         
	    List<Product> ps = session.selectList("listProduct5",ids);
	    for (Product p : ps) {
	    	System.out.println(p);
	    }
        session.commit();
        session.close();
		
	}
	
	private static void deleteOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder",1);
        Product p6 = session.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        session.delete("deleteOrderItem", oi);     
    }
	
	private static void addOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder", 1);
        Product p6 = session.selectOne("getProduct", 6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        oi.setNumber(200);
 
        session.insert("addOrderItem", oi);
    }
	
	private static void listOrder(SqlSession session) {
        List<Order> os = session.selectList("listOrder");
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois= o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
            }
        }
    }
	
	private static void listAll(SqlSession session) {
        List<Category> cs = session.selectList("listCategory");
	    for (Category c : cs) {
	        System.out.println(c.getName());
	    }
	}
}
