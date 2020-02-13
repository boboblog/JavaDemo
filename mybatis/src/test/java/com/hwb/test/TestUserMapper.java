package com.hwb.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.hwb.mapper.UserMapper;
import com.hwb.pojo.SysPrivilege;
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
	
	@Ignore
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
	
	@Ignore
	@Test
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1l);
			Assert.assertNotNull(user);
			Assert.assertEquals(1, userMapper.deleteById(1L));
			//再次查询，此时该数据已被删除，查询结果应为空
			Assert.assertNull(userMapper.selectById(1L));
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectRolesByUserIDAndRoleEnabled() {
		SqlSession sqlSession = getSqlSession();
		try{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRoleByUserIdAndRoleEnabled(1L, 1);
			Assert.assertNotNull(roleList);
			Assert.assertTrue(roleList.size() > 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectByUser() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//仅查询用户名
			SysUser query = new SysUser();
			query.setUserName("ad");
			List<SysUser> userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() > 0);
			//仅查询用户邮箱
			query = new SysUser();
			query.setUserEmail("test@mybatis.tk");
			userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() > 0);
			//同时查询用户名和邮箱
			query = new SysUser();
			query.setUserName("ad");
			query.setUserEmail("test@mybatis.tk");
			userList = userMapper.selectByUser(query);
			//数据库中无同时满足该条件的用户，所以查询结果数目为0
			Assert.assertTrue(userList.size() == 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testUpdateByIdSelective() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个新的user对象
			SysUser user = new SysUser();
			//更新id为1的用户
			user.setId(1L);
			//修改邮箱
			user.setUserEmail("test@mybatis.tk");
			//更新邮箱
			int result = userMapper.updateByIdSelective(user);
			//只更新一条数据
			Assert.assertEquals(1, result);
			//根据当前id查询修改后的数据
			user = userMapper.selectById(1L);
			//修改后的名字保持不变，但是邮箱更新了
			Assert.assertEquals("admin", user.getUserName());
			Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testInsert2Selective() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("test-selective");
			user.setUserPassword("123456");
			user.setUserInfo("test info");
			user.setCreateTime(new Date());
			//插入数据库
			userMapper.insert2(user);
			//获取插入的数据
			user = userMapper.selectById(user.getId());
			Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectByIdOrUserName() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//查询用户名
			SysUser query = new SysUser();
			query.setId(1L);
			query.setUserName("admin");
			SysUser user = userMapper.selectByIdOrUserName(query);
			Assert.assertNotNull(user);
			//id设为空
			query.setId(null);
			user = userMapper.selectByIdOrUserName(query);
			Assert.assertNotNull(user);
			//id和userName都为空
			query.setUserName(null);
			Assert.assertNull(user);
		}finally{
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectByIdList() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<Long> idList = new ArrayList<Long>();
			idList.add(1L);
			idList.add(1001L);
			List<SysUser> userList = userMapper.selectByIdList(idList);
			Assert.assertEquals(2, userList.size());
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testInsertList() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = new ArrayList<SysUser>();
			for(int i = 0; i < 2; i++) {
				SysUser user = new SysUser();
				user.setUserName("test" + i);
				user.setUserPassword("123456");
				user.setUserEmail("test@mybatis.tk");
				userList.add(user);
			}
			int result = userMapper.insertList(userList);
			Assert.assertEquals(2, result);
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	@Ignore
	@Test
	public void testUpdateByMap() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 1L);
			map.put("user_email", "test@mybatis.tk");
			map.put("user_password", "12345678");
			userMapper.updateByMap(map);
			SysUser user = userMapper.selectById(1L);
			Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectUserAndRoleById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoleById(1001L);
			Assert.assertNotNull(user);
			Assert.assertNotNull(user.getRole());
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectUserAndRoleByIdSelect() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoleByIdSelect(1001L);
			Assert.assertNotNull(user);
			System.out.println("调用user.getRole()");
			Assert.assertNotNull(user.getRole());
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectAllUserAndRoles() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAllUserAndRoles();
			System.out.println("用户数：" + userList.size());
			for(SysUser user : userList) {
				System.out.println("用户名：" + user.getUserName());
				for(SysRole role : user.getRoleList()) {
					System.out.println("角色名：" + role.getRoleName());
					for(SysPrivilege privilege : role.getPrivilegeList()) {
						System.out.println("权限名:" + privilege.getPrivilegeName());
					}
				}
			}
		}finally {
			sqlSession.close();
		}
	}
	
	@Ignore
	@Test
	public void testSelectAllUserAndRolesSelect() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectAllUserAndRolesSelect(1L);
			System.out.println("用户名：" + user.getUserName());
			for(SysRole role : user.getRoleList()) {
				System.out.println("角色名：" + role.getRoleName());
				for(SysPrivilege privilege : role.getPrivilegeList()) {
					System.out.println("权限名：" + privilege.getPrivilegeName());
				}
			}
		}finally {
			sqlSession.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
