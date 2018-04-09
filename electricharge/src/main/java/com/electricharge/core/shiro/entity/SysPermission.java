package com.electricharge.core.shiro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author linjiayong
 * @since 2017-09-01
 */
@TableName("sys_permission")
public class SysPermission  {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	@TableField("parent_id")
	private Integer parentId;
	@TableField("parent_ids")
	private String parentIds;
	private String permission;
	@TableField("resource_type")
	private String resourceType;
	private String url;


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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysPermission{" +
			"id=" + id +
			", name=" + name +
			", parentId=" + parentId +
			", parentIds=" + parentIds +
			", permission=" + permission +
			", resourceType=" + resourceType +
			", url=" + url +
			"}";
	}
}
