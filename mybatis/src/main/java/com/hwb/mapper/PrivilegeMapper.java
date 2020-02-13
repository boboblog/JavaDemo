package com.hwb.mapper;

import java.util.List;

import com.hwb.pojo.SysPrivilege;

public interface PrivilegeMapper {
	
	/**
	 * 依据角色id来查询其所拥有的权限
	 * 
	 * @param roleId
	 * @return
	 */
	List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}	
