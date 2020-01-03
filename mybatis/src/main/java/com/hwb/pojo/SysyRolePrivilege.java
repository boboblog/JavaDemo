package com.hwb.pojo;
/**
 * 角色权限关联表
 */
public class SysyRolePrivilege {

	//角色id
	private Long roleId;
	//权限id
	private Long privilegeId;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

}
