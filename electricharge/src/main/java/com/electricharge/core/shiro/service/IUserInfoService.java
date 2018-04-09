package com.electricharge.core.shiro.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricharge.core.shiro.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */
public interface IUserInfoService extends IService<UserInfo> {
    public UserInfo selectUserByUserNameWithRole(String userName);
    public List all();
}
