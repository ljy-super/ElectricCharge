package com.electricharge.core.shiro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 * 系统角色实体类;
 * @author linjiayong
 * @since 2017-08-24
 */
@TableName("sys_role")
public class SysRole  {

    private static final long serialVersionUID = 1L;

	private String available;// 是否可用,如果不可用将不会添加给用户
	private String description; // 角色描述,UI界面显示使用
	private Long id;// 编号
	private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:

	@TableField(exist = false)
	private List<SysPermission> permissions;// 角色 - 权限关系定义;

	@TableField(exist = false)
	private List<UserInfo> userInfos;// 一个角色对应多个用户
	public String getAvailable () {
		return available ;
	}

	public void setAvailable (String available ) {
		this.available  = available ;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysRole{" +
			"available=" + available  +
			", description=" + description +
			", id=" + id +
			", role=" + role +
			"}";
	}
}
