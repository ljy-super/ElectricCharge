package com.electricharge.config.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.electricharge.core.shiro.entity.UserInfo;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by linjiayong on 2017/8/23.
 */
@Component
public class MyMetaObjectHandler  extends MetaObjectHandler {
    //新增填充
    @Override
    public void insertFill(MetaObject metaObject) {
        //"editor", "creator", "createTime" , "editTime", "isDel"
/***
 * 原始方法
 */
//        Object editor = metaObject.getValue("editor");
//        Object editTime = metaObject.getValue("editTime");
        //获取当前登录用户
//        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
//        if (null == lastUpdateNameId) {
//            metaObject.setValue("lastUpdateNameId", user.getId());
//        }
//        if (null == lastUpdateTime) {
//            metaObject.setValue("lastUpdateTime", new Date());
//        }
        Subject subject = SecurityUtils.getSubject();//当前会话

        Object editor = getFieldValByName("editor",metaObject);
        Object editTime = getFieldValByName("editTime",metaObject);

        Object creator = getFieldValByName("creator",metaObject);
        Object createTime = getFieldValByName("createTime",metaObject);
        Object isDel = getFieldValByName("isDel",metaObject);




        if (null == editor) {
            if( subject.isAuthenticated()){
                UserInfo userInfo=(UserInfo) subject.getPrincipal();
                setFieldValByName("editor",  userInfo.getUserName(), metaObject);
            }

            //setFieldValByName("editor",  "linjiayong", metaObject);
        }
        if (null == editTime) {
            setFieldValByName("editTime",  new Date(), metaObject);
        }

        if (null == creator) {
            if( subject.isAuthenticated()){
                UserInfo userInfo=(UserInfo) subject.getPrincipal();
                setFieldValByName("creator",  userInfo.getUserName(), metaObject);
            }
         //   setFieldValByName("creator",  "linjiayong", metaObject);
        }
        if (null == createTime) {
            setFieldValByName("createTime", new Date(), metaObject);
        }
        if (null == isDel) {
            setFieldValByName("isDel",Boolean.FALSE, metaObject);
        }
    }

    //更新填充
    @Override
    public void updateFill(MetaObject metaObject) {
//        Object editor = metaObject.getValue("editor");
//        Object editTime = metaObject.getValue("editTime");
//        if (null == editor) {
//            metaObject.setValue("editor", "linjiayong");
//        }
//        if (null == editTime) {
//            metaObject.setValue("editTime",  new Date());
//        }
        Subject subject = SecurityUtils.getSubject();//当前会话
        if( subject.isAuthenticated()){
            UserInfo userInfo=(UserInfo) subject.getPrincipal();
            setFieldValByName("editor",  userInfo.getUserName(), metaObject);
        }
        setFieldValByName("editTime",  new Date(), metaObject);
//        insertFill(metaObject);
    }
}
