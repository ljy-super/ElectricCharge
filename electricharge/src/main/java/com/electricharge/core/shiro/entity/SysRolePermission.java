package com.electricharge.core.shiro.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 * 权限和角色关系表
 * @author linjiayong
 * @since 2017-08-24
 */
@TableName("sys_role_permission")
public class SysRolePermission  {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Long permissionId;
	private Long roleId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysRolePermission{" +
			"id=" + id +
			", permissionId=" + permissionId +
			", roleId=" + roleId +
			"}";
	}
}
