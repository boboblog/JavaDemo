package com.hwb.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.hwb.mapper.UserMapper;
import com.hwb.pojo.SysRole;
import com.hwb.pojo.SysUser;

public class TestUserMapper extends TestBaseMapper {
	
	@Ignore
	@Test
	public void testSelectById() {
		//获取SQLSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取userMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用selectById方法，查询id=1的用户
			SysUser user = userMapper.selectById(1l);
			//user不为空
			Assert.assertNotNull(user);
			Assert.assertEquals("admin", user.getUserName());
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用selectAll方法，查询所有用户
			List<SysUser> userList = userMapper.selectAll();
			//查询结果不为空
			Assert.assertNotNull(userList);
			//用户数量大于0个
			Assert.assertTrue(userList.size() > 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectRoleByUserId() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用selectAll方法，查询所有用户
			List<SysRole> roleList = userMapper.selectRoleByUserId(1l);
			//查询结果不为空
			Assert.assertNotNull(roleList);
			//角色数量大于0个
			Assert.assertTrue(roleList.size() > 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("测试用户1");
			user.setUserPassword("123456");
			user.setUserEmail("test@2020.1.10@.com");
			user.setUserInfo("测试新增用户");
			user.setHeadImg(new byte[] {1, 2, 3});
			user.setCreateTime(new Date());
			//调用inset方法，新增一个用户
			int result = userMapper.insert(user);			
			//仅插入了一条数据
			Assert.assertEquals(1, result);
			//id为null，没有给id赋值，并且没有配置回写id的值
			Assert.assertNull(user.getId());
		}finally{
			//为了不影响其他测试，这里选择回滚，由于默认的sqlSessionFactory.openSession()是不自动提交的，因此不手动执行commit也不会提交到数据库
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("测试用户1");
			user.setUserPassword("123456");
			user.setUserEmail("test@2020.1.10@.com");
			user.setUserInfo("测试新增用户");
			user.setHeadImg(new byte[] {1, 2, 3});
			user.setCreateTime(new Date());
			//调用inset方法，新增一个用户
			int result = userMapper.insert2(user);
			System.out.println("插入数据数目：" + result);
			System.out.println("插入数据主键：" + user.getId());
			//仅插入了一条数据
			Assert.assertEquals(1, result);
			//因为id回写，所以id不为null
			Assert.assertNotNull(user.getId());
		}finally{
			//为了不影响其他测试，这里选择回滚，由于默认的sqlSessionFactory.openSession()是不自动提交的，因此不手动执行commit也不会提交到数据库
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("测试用户1");
			user.setUserPassword("123456");
			user.setUserEmail("test@2020.1.10@.com");
			user.setUserInfo("测试新增用户");
			user.setHeadImg(new byte[] {1, 2, 3});
			user.setCreateTime(new Date());
			//调用inset方法，新增一个用户
			int result = userMapper.insert3(user);
			System.out.println("插入数据数目：" + result);
			System.out.println("插入数据主键：" + user.getId());
			//仅插入了一条数据
			Assert.assertEquals(1, result);
			//因为id回写，所以id不为null
			Assert.assertNotNull(user.getId());
		}finally{
			//为了不影响其他测试，这里选择回滚，由于默认的sqlSessionFactory.openSession()是不自动提交的，因此不手动执行commit也不会提交到数据库
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1l);
			//当前userName为admin
			Assert.assertEquals("admin", user.getUserName());
			user.setUserName("admin_test");
			int result = userMapper.updateById(user);
			//更新了一条数据
			Assert.assertEquals(1, result);
			//查询修改后的名字
			user = userMapper.selectById(1l);
			Assert.assertEquals("admin_test", user.getUserName());
		}finally{
			//为了不影响其他测试，这里选择回滚，由于默认的sqlSessionFactory.openSession()是不自动提交的，因此不手动执行commit也不会提交到数据库
			sqlSession.rollback();
			sqlSession.close();
		}
	}
}
