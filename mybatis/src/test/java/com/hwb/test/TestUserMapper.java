package com.hwb.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
	

	@Test
	public void testSelectByIdList() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			List<Long> idList = new ArrayList<Long>();
//			idList.add(1L);
//			idList.add(1001L);
			SysUser sysUser = new SysUser();
			String[] strings = {"1","2"};
			sysUser.addExtField("ids", strings);
			List<SysUser> userList = userMapper.selectByIdList(sysUser);
			for(SysUser sysUsersUser : userList) {
				System.out.println("用户名："+sysUser.getUserName());
			}
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
	
	@Ignore
	@Test
	public void test1() {
		String[] s = {"1","2"};
		String[] s2 = {};
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		for(int i=0; i<s.length; i++) {
			sb1.append(s[i]);
			if(i<s.length-1) {
				sb1.append(',');
			}
		}
		for(int i=0; i<s2.length; i++) {
			sb2.append(s2[i]);
			if(i<s2.length-1) {
				sb2.append(',');
			}
		}
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		if(sb1.length()!=0 && sb2.length()!=0) {
			sb1.append(',');
			sb1.append(sb2);
		}
		
		System.out.println(sb1.toString());
		
	}
	
	@Ignore
	@Test
	public void test2() {
		String type = "3";
		switch(type) {
			case "1":
				System.out.println(1);
			case "2":
				System.out.println(2);
			default:
				System.out.println(3);
		}
	}
	
	@Ignore
	@Test
	public void test3() {
		HashMap<String, Object> valueMap = new HashMap<>();
        StringBuffer sb1 = new StringBuffer();
        String[] array = {};
        valueMap.put("searchName", "");
        valueMap.put("enterpriseType", "");
        valueMap.put("s_tagIds", "");
        valueMap.put("s_purchaseIds", "");
        valueMap.put("s_purchaseNames", "");
        System.out.println("开始转换");
        
        String[] s_purchaseIds = {};
        if(valueMap.get("s_purchaseIds") !=null ) {
        	s_purchaseIds = (String[]) valueMap.get("s_purchaseIds");
            System.out.println("转换成功");
        }
       

//        String s_tagIds = (String)valueMap.get("s_tagIds");
//        if (s_tagIds != null && s_tagIds.length() != 0) {
//            String[] s_array = s_tagIds.split(",");
//            Long[] tagIds = new Long[s_array.length];
//            for (int i = 0; i < s_array.length; i++) {
//                tagIds[i] = Long.valueOf(s_array[i]);
//            }
//            System.out.println("根据会员等级查询所对应的租户id：" + tagIds);
//        }
        if(s_purchaseIds != null && s_purchaseIds.length != 0){
        	Long[] purchaseIds = new Long[s_purchaseIds.length];
            for (int i = 0; i < s_purchaseIds.length; i++) {
                purchaseIds[i] = Long.valueOf(s_purchaseIds[i]);
            }
            System.out.println("采购商id:" + s_purchaseIds);
        }
        
        System.out.println("不执行");
	 }
	
	@Ignore
	@Test
	public void test() {
		
		SysUser sysUser0 = new SysUser();
		sysUser0.setId(0l);
		SysUser sysUser1 = new SysUser();
		sysUser1.setId(1l);
		SysUser sysUser2 = new SysUser();
		sysUser2.setId(3l);

		List<SysUser> sList = new ArrayList<SysUser>();

		List<SysUser> sList2 = new ArrayList<SysUser>();
		
		sList.add(sysUser0);
		sList.add(sysUser1);
		sList.add(sysUser2);
		
		sList2.add(sysUser1);
		sList2.add(sysUser2);
		
		for(SysUser s1 : sList) {
			for(SysUser s2 : sList2) {
				if(s1.getId().equals(s2.getId())) {
					sList.remove(s1);
					sList2.remove(s2);
					continue;
				}
			}
		}
		
		if(!sList.isEmpty()) {
			System.out.println("s1:");
			for(SysUser s1 : sList) {
				System.out.println(s1.getId());
			}
		}
		if(!sList2.isEmpty()) {
			System.out.println("s2");
			for(SysUser s2 : sList2) {
				System.out.println(s2.getId());
			}
		}
	}
	
	@Ignore
	@Test
	public void test6() {
		SysUser sysUser0 = new SysUser();
		sysUser0.setId(0l);
		SysUser sysUser1 = new SysUser();
		sysUser1.setId(1l);
		SysUser sysUser2 = new SysUser();
		sysUser2.setId(3l);
		List<SysUser> sList = new ArrayList<SysUser>();
		sList.add(sysUser0);
		sList.add(sysUser1);
		sList.add(sysUser2);
		for(SysUser sysUser : sList) {
			if(sysUser.getId() == 1l) {
				sList.remove(sysUser);
			}
		}
		for(SysUser sysUser : sList) {
			System.out.println(sysUser.getId());
		}
	}
	
	@Ignore
	@Test
	public void test7() {
	     List<Integer> listA=new ArrayList<>();
	     listA.add(1);
	     listA.add(2);
	     listA.add(3);
	     List<Integer> listB=new ArrayList<>();
	     listB.add(1);
	     listB.add(5);
	     listB.add(2);
	     
	     Iterator<Integer> ita = listA.iterator();
	     Iterator<Integer> itb = listB.iterator();
	     int i = 0;
	     while (ita.hasNext()) {
	    	 Integer a = ita.next();
	    	 System.out.println("a:"+a);
		     while (itb.hasNext()) {
		    	 Integer b= itb.next();
		    	 System.out.println("b:"+b);
		    	 if(a==b) {
		    		 ita.remove();
		    		 itb.remove();
		    	 }
		    	 i++;
		    	 System.out.println("比较次数："+i);
			}
		}
	    
	     for(Integer integer : listA) {
	    	 System.out.println(integer);
	     }
	     for(Integer integer : listB) {
	    	 System.out.println(integer);
	     }
	}
	
	@Ignore
	@Test
	public void test8() {
	     List<Integer> listA=new ArrayList<>();
	     listA.add(1);
	     listA.add(2);
	     listA.add(9);
	     listA.add(4);
	     List<Integer> listB=new ArrayList<>();
	     listB.add(1);
	     listB.add(5);
	     listB.add(9);
	     listB.add(2);
	     int z=0;
	     List<Integer> listC = new ArrayList<Integer>();
	     //移除b中相同
	     for(int i=0; i<listA.size(); i++) {
	    	 for(int j=0; j<listB.size(); j++) {    		
	    		 if(listA.get(i) == listB.get(j)) {	
	    			 listC.add(listB.get(j));
	    			 listB.remove(listB.get(j));
	    			 j--;
	    			 continue;
	    		 }
	    		 z++;
	    	 }
	     }
	     //移除a中相同
	     for(int i=0; i<listC.size(); i++) {
	    	 for(int j=0; j<listA.size(); j++) {
	    		 if(listC.get(i) == listA.get(j)  ) {
	    			 listA.remove(listA.get(j));
	    			 j--;
	    			 continue;
	    		 }
	    	 }
	     }
	     
	     System.out.println("遍历总次数："+z);
	     System.out.println("lista:");
	     for(Integer integer : listA) {
	    	 System.out.println(integer);
	     }
	     System.out.println("listb");
	     for(Integer integer : listB) {
	    	 System.out.println(integer);
	     }
	     System.out.println("listc");
	     for(Integer integer : listC) {
	    	 System.out.println(integer);
	     }
	}
	
	@Ignore
	@Test
	public void test9() {
	     List<Integer> listA=new ArrayList<>();
	     listA.add(1);
	     listA.add(2);
	     listA.add(3);
	     List<Integer> listB=new ArrayList<>();
	     listB.add(1);
	     listB.add(5);
	     listB.add(2);
	     int z=0;
	     for(int i=0; i<listA.size(); i++) {
	    	 if(listA.get(i)==3) {
	    		 listA.remove(i);
	    		 i--;
	    	 }
	     }
	    
	     for(Integer integer : listA) {
	    	 System.out.println(integer);
	     }
	     for(Integer integer : listB) {
	    	 System.out.println(integer);
	     }
	}
	
	@Ignore
	@Test
	public void test11() {
		String a = null;
		String b = "";
		System.out.println(b.equals(a));
		System.out.println(a.equals(b));
	}
	
	@Ignore
	@Test
	public void test22() {
		String[] strings = {"1","2","3"};
		HashMap<String, Object> map = new HashMap<>();
		map.put("strings", strings);
	
		Object[] objects = (Object[]) map.get("strings");
		for(int i=0; i<objects.length; i++) {
			System.out.println(objects[i]);
		}
	}
	
	
}
