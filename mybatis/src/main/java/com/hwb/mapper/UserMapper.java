package com.hwb.mapper;

import java.util.List;

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
	
}
