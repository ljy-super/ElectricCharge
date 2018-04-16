package com.electricharge.core.shiro.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.electricharge.base.MySearch;
import com.electricharge.base.MyUtils;
import com.electricharge.core.shiro.entity.SysRole;
import com.electricharge.core.shiro.entity.SysRoleUser;
import com.electricharge.core.shiro.entity.UserInfo;
import com.electricharge.core.shiro.service.ISysRoleService;
import com.electricharge.core.shiro.service.ISysRoleUserService;
import com.electricharge.core.shiro.service.IUserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    IUserInfoService iUserInfoService;

    @Autowired
    ISysRoleService sysRoleService;

    @Autowired
    ISysRoleUserService iSysRoleUserService;

    @RequestMapping("userMain")
    @RequiresPermissions("user:main")
    public String main() {
        return "main/userMain";
    }
    /**
     * 用户查询.
     * @return
     */
    @ResponseBody
    @RequestMapping("/userList")
    @RequiresPermissions("user:list")
    public Map userList(@RequestBody MySearch<UserInfo> myPage){

        Wrapper<UserInfo> wrapper=new EntityWrapper();
//        if(myPage.getDormitoryCode()!=null&& myPage.getDormitoryCode().length()>0){
//            wrapper.like("code",myPage.getDormitoryCode());
//        }
        iUserInfoService.selectPage(myPage,wrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", myPage.getRecords());
        map.put("total", myPage.getTotal());
        return map;

    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userSave")
    @RequiresPermissions("userInfo:save")//权限管理;
    @ResponseBody
    public Map userInfoAdd(UserInfo userInfo){
        Wrapper<UserInfo> wrapper=new EntityWrapper();
        wrapper.eq("user_name",userInfo.getUserName());
        if(userInfo.getId()==null){
            int i = iUserInfoService.selectCount(wrapper);
            if(i>0){
                Map<String, Object> map = new HashMap<>();
                map.put("success", Boolean.FALSE);
                map.put("msg", "存在该账号!");
                return map;
            }
        }
        try {
            String s = MyUtils.getMd5Syr(userInfo.getPassword());
            userInfo.setPassword(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean b = iUserInfoService.insertOrUpdate(userInfo);
        if(userInfo.getId()!=null){
            Map<String,Object> map = new HashMap();
            map.put("uid",userInfo.getId());
            iSysRoleUserService.deleteByMap(map);
        }

        Long id = null;
        if(userInfo.getId()==null){
            Integer o = (Integer) iUserInfoService.selectObj(wrapper);
            id=(long)o;
        }else{
            id=userInfo.getId();
        }
        SysRoleUser sysRoleUser=new SysRoleUser();
        sysRoleUser.setRoleId((long)userInfo.getType());
        sysRoleUser.setUid(id);
        iSysRoleUserService.insert(sysRoleUser);
        Map<String, Object> map = new HashMap<>();
        map.put("success", b);
        return map;
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    @ResponseBody
    public Map userDel(@RequestParam("ids[]")List<Integer> ids){
        boolean b = iUserInfoService.deleteBatchIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("success", b);
        return map;
    }

    @ResponseBody
    @RequestMapping("/getType")
    public List getType(){
        Map<String,Object> map = new HashMap();
        map.put("available",1);
        List<SysRole> sysRoles = sysRoleService.selectByMap(map);
        return sysRoles;
    }

}
