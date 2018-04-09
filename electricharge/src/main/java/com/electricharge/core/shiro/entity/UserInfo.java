package com.electricharge.core.shiro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *用户信息
 * @author linjiayong
 * @since 2017-08-24
 */
@TableName("user_info")
public class UserInfo  {

    private static final long serialVersionUID = 1L;

	private Long id;//用户id;
	private String name;//名称（昵称或者真实姓名，不同系统不同定义）
	private String password; //密码;
	private String salt;//加密密码的盐  暂时不用
	private Integer state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
	@TableField("user_name")
	private String userName; //账号.

	@TableField(exist=false)
	private List<SysRole> roleList;// 一个用户具有多个角色

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 密码盐.
	 * @return
	 */
	public String getCredentialsSalt(){
		return this.userName+this.salt;
	}

	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
			"id=" + id +
			", name=" + name +
			", password=" + password +
			", salt=" + salt +
			", state=" + state +
			", userName=" + userName +
			"}";
	}
}
