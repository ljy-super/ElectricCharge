package com.electricharge.dormitory.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.electricharge.base.BaseController;
import com.electricharge.base.MySearch;
import com.electricharge.dormitory.entity.Dormitory;
import com.electricharge.dormitory.service.IDormitoryService;
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
 * @since 2018-04-10
 */
@Controller
@RequestMapping("/dormitory")
public class DormitoryController extends BaseController {

    @Autowired
    IDormitoryService dormitoryServiceImpl;

    @RequiresPermissions(" dormitory:view")//权限管理;
    @RequestMapping("main")
    public String  main(){
        return "main/dormitoryMain";
    }



    @ResponseBody
    @RequiresPermissions(" dormitory:list")//权限管理;
    @RequestMapping("getDormitoryList")
    public Map  getDormitoryList(@RequestBody MySearch<Dormitory> myPage){
        Wrapper<Dormitory> wrapper=new EntityWrapper();
        if(myPage.getDormitoryCode()!=null&& myPage.getDormitoryCode().length()>0){
            wrapper.like("code",myPage.getDormitoryCode());
        }
        dormitoryServiceImpl.selectPage(myPage,wrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", myPage.getRecords());
        map.put("total", myPage.getTotal());
        return map;
    }

    @ResponseBody
    @RequiresPermissions(" dormitory:save")//权限管理;
    @RequestMapping("saveDormitory")
    public Map saveDormitory(Dormitory dormitory){
        boolean b = dormitoryServiceImpl.insertOrUpdateAllColumn(dormitory);
        Map<String, Object> map = new HashMap<>();
        map.put("success", b);
        return map;
    }

    @RequiresPermissions(" dormitory:del")//权限管理;
    @ResponseBody
    @RequestMapping("delDormitory")
    public Map delDormitory(@RequestParam("ids[]")List<Integer> ids){
//        List<Integer> list = Arrays.asList(ids);
        boolean b = dormitoryServiceImpl.deleteBatchIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("success", b);
        return map;
    }
}

