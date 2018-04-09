package com.electricharge.core.shiro.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricharge.core.shiro.entity.SysRole;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */
public interface ISysRoleService extends IService<SysRole> {
    public SysRole  selectRoleByIdWithPermission(Long id);
}
