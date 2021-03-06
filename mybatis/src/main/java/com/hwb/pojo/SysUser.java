package com.hwb.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 用户表
 */
public class SysUser {
	
	//用户ID
	private Long id;
	
	private String ids;
	private Map<String, Object> extFields;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public Map<String, Object> getExtFields() {
		return extFields;
	}
	public void setExtFields(Map<String, Object> extFields) {
		this.extFields = extFields;
	}

	 public void addExtField(String fieldName, Object filedValue)
	  {
	    if (this.extFields == null) {
	      this.extFields = new HashMap();
	    }
	    this.extFields.put(fieldName, filedValue);
	  }

	//用户名
	private String userName;
	//用户密码
	private String userPassword;
	//用户邮箱
	private String userEmail;
	//简介
	private String userInfo;
	//头像
	private byte[] headImg;
	//创建时间
	private Date createTime;
	//用户角色
	private SysRole role;
	//用户角色集合
	private List<SysRole> roleList;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public byte[] getHeadImg() {
		return headImg;
	}
	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
}
