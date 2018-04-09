package com.electricharge.core.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.electricharge.core.shiro.entity.SysRole;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
        public SysRole  selectRoleByIdWithPermission(Long id);
}