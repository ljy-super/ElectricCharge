package com.electricharge.core.shiro.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 * 用户和角色关系表
 * @author linjiayong
 * @since 2017-08-24
 */
@TableName("sys_role_user")
public class SysRoleUser  {

    private static final long serialVersionUID = 1L;

	private Long id;
	private Long roleId;
	private Long uid;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}


	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysRoleUser{" +
			"id=" + id +
			", roleId=" + roleId +
			", uid=" + uid +
			"}";
	}
}
