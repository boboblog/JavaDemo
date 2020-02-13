package com.hwb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hwb.pojo.SysRole;
import com.hwb.pojo.SysUser;

public interface UserMapper {
	
	/**
	 * 通过id查询用户
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectById(long id);
	
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */ 
	List<SysUser> selectAll();
	
	/**
	 * 根据用户id获取角色信息
	 * 
	 * @param userId
	 * @return 
	 */
	List<SysRole> selectRoleByUserId(Long userId);
	
	/**
	 * 新增用户
	 * 
	 * @param sysUser
	 * @return
	 */
	int insert(SysUser sysUser);
	
	/*
	 * 新增用户-使用userGeneratedKeys方式
	 * 
	 * @param sysUser
	 * @return
	 */
	int insert2(SysUser sysUser);
	
	/*
	 * 新增用户-使用selectKey方式
	 * 
	 * @param sysUser
	 * @return
	 */
	int insert3(SysUser sysUser);
	
	/**
	 * 根据主键更新
	 * 
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
	
	/**
	 * 通过主键删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
	
	/**
	 * 通过用户id和角色的enabled状态获取用户的角色
	 * 
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRoleByUserIdAndRoleEnabled(@Param("userId")Long userId, @Param("enabled")Integer enabled);
	
	/**
	 * 根据动态条件查询用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	List<SysUser> selectByUser(SysUser sysUser);
	
	/**
	 * 根据主键更新
	 * 
	 * @param sysUser
	 * @return
	 */
	int updateByIdSelective(SysUser sysUser);
	
	/**
	 * 根据用户id或用户名查询
	 * 
	 * @param sysUSer
	 * @return
	 */
	SysUser selectByIdOrUserName(SysUser sysUser);
	
	/**
	 * 根据用户id集合查询
	 * 
	 * @param idList
	 * @return
	 */
	List<SysUser> selectByIdList(List<Long> idList);
	
	/**
	  * 批量插入用户信息
	 *
	 * @param userList
	 * @return
	 */
	int insertList(List<SysUser> userList);
	
	/**
	 * 通过Map更新列
	 * 
	 * @param
	 * @return
	 */
	int updateByMap(@Param("mm")Map<String, Object> map);
	
	/**
	 * 根据用户id获取用户信息和用户的角色信息
	 * 
	 * @param
	 * @return
	 */
	SysUser selectUserAndRoleById(Long id);
	
	/**
	 * 根据用户id获取用户和用户的角色信息，嵌套查询方式
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoleByIdSelect(Long id);
	
	/**
	 * 获取所有用户及其对应的角色
	 * 
	 * @return
	 */
	List<SysUser> selectAllUserAndRoles();
	
	/**
	 * 根据用户id获取用户的信息及所属角色信息和权限信息
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectAllUserAndRolesSelect(Long id);
}
