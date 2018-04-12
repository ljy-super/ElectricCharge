package com.electricharge.core.shiro.web;


import com.electricharge.core.shiro.entity.UserInfo;
import com.electricharge.core.shiro.service.IUserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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


   /* @RequiresAuthentication
	@RequestMapping("getUser")
    public UserInfo getUser(){
        UserInfo userInfo = iUserInfoService.selectUserByUserNameWithRole("admin");

        return userInfo;
    }

    @RequestMapping("addUser")
//    @RequiresRoles(value = "manage")
    public UserInfo addUser(String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(name);
        iUserInfoService.insert(userInfo);
        return userInfo;
    }

    @RequestMapping("delUser")
    public Map delUser(){
        Map<String, String> map = new HashMap<>();
        iUserInfoService.deleteById((long)13);
        return map;
    }*/

    @RequestMapping("userMain")
    public String main() {
        return "main/userMain";
    }
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    public ModelAndView userInfo(){
        ModelAndView userInfo = new ModelAndView("userInfo");
        UserInfo user= new UserInfo();
        user.setUserName("lin");
        userInfo.addObject("userInfo",user);
        return userInfo;
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }


    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
