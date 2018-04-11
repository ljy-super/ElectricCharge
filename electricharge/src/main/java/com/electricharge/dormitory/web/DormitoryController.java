package com.electricharge.dormitory.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.electricharge.dormitory.entity.Dormitory;
import com.electricharge.dormitory.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.HashMap;
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
public class DormitoryController {

    @Autowired
    IDormitoryService dormitoryServiceImpl;

    @RequestMapping("main")
    public String  main(){
        return "main/dormitoryMain";
    }

    @ResponseBody
    @RequestMapping("getDormitoryList")
    public Map  getDormitoryList(ServletRequest request){
        Page<Dormitory> page = new Page<>();
        dormitoryServiceImpl.selectPage(page);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", page.getRecords());
        map.put("total", page.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("saveDormitory")
    public Map saveDormitory(Dormitory dormitory){
        boolean b = dormitoryServiceImpl.insertOrUpdateAllColumn(dormitory);
        Map<String, Object> map = new HashMap<>();
        map.put("success", b);
        return map;
    }
}

