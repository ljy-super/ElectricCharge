package com.electricharge.student.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.electricharge.student.entity.Student;
import com.electricharge.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linjiayong
 * @since 2018-04-12
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @ResponseBody
    @RequestMapping("getStudent")
    public Student getStudent( Long userId){
        Wrapper<Student> wrapper=new EntityWrapper();
        wrapper.eq("userId",userId);
       return iStudentService.selectOne(wrapper);
    }
    @ResponseBody
    @RequestMapping("save")
    public Map saveStudent( Student student){
        boolean b = iStudentService.insertOrUpdate(student);
        Map<String, Object> map = new HashMap<>();
        map.put("success", b);
        return map;
    }
}

