package com.hwb.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

public class TestBaseMapper {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			inputStream.close();
//			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//			reader.close();
		}catch(IOException ignore) {
			ignore.printStackTrace();
		}
	}
	
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}
