package com.electricharge.core.shiro.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricharge.core.shiro.entity.SysRole;
import com.electricharge.core.shiro.mapper.SysRoleMapper;
import com.electricharge.core.shiro.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Override
    public SysRole selectRoleByIdWithPermission(Long id) {
        return sysRoleMapper.selectRoleByIdWithPermission(id);
    }
}
