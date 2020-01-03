package com.hwb.pojo;
/**
 * 角色表
 */
import java.util.Date;

public class SysRole {
	
	
	//角色id
	private Long id;
	//角色名
	private String roleName;
	//有效标志
	private int enabled;
	//创建人
	private Long createBy;
	//创建时间
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
