package com.hwb.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.hwb.mapper.UserMapper;
import com.hwb.pojo.SysUser;


public class TestCache extends TestBaseMapper {
	
	@Ignore
	@Test
	public void testL1Cache() {
		SqlSession sqlSession = getSqlSession();
		SysUser user1 = null;
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			user1 = userMapper.selectById(1l);
			user1.setUserName("user1Name");
			SysUser user2 = userMapper.selectById(1l);
			//虽然未更新数据库，但是第二次查询的用户名和刚才重新赋值的名字相同
			Assert.assertEquals("user1Name", user2.getUserName());
			//此处user1、user2是同一个实例
			Assert.assertEquals(user1, user2);
		}finally {
			sqlSession.close();
		}
		
		System.out.println("开启一个新的sqlSession");
		sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user2 = userMapper.selectById(1l);
			//第二个session获取的用户名仍然是admin
			Assert.assertEquals("admin", user2.getUserName());
			//但是第二个session查询的user2和user1是两个不同的实例
			Assert.assertNotEquals(user1, user2);
		}finally {
			sqlSession.close();
		}
		
	}
}
