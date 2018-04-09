package com.electricharge.core.shiro.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricharge.core.shiro.entity.UserInfo;
import com.electricharge.core.shiro.mapper.UserInfoMapper;
import com.electricharge.core.shiro.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    public UserInfo selectUserByUserNameWithRole(String userName){
        UserInfo userInfo = userInfoMapper.selectUserByUserNameWithRole(userName);
        return userInfo;
    }

    @Override
    public List all() {
     return    userInfoMapper.all();
    }
}
