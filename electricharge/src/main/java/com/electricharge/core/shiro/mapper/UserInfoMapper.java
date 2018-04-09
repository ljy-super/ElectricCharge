package com.electricharge.core.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.electricharge.core.shiro.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    public UserInfo selectUserByUserNameWithRole(String userName);

    public List<Map<String,Object >> all();

}