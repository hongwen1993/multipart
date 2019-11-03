package com.kagura.service2.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kagura.service2.StudentService;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/3 19:52
 * @since 1.0.0
 */
@Component
@Service(interfaceClass = StudentService.class)
public class StudentServiceImpl implements StudentService {
    @Override
    public String getStudent(Long id) {
        System.err.println("执行getStudent方法");
        return "我是" + id + "号学生";
    }
}
