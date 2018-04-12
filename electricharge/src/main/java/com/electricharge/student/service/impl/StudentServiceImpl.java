package com.electricharge.student.service.impl;

import com.electricharge.student.entity.Student;
import com.electricharge.student.mapper.StudentMapper;
import com.electricharge.student.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linjiayong
 * @since 2018-04-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
