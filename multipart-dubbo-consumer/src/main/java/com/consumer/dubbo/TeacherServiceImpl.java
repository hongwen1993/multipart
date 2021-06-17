package com.consumer.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.kagura.consumer.TeacherService;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/3 20:40
 * @since 1.0.0
 */
@Component
@Service(timeout = 3000)
public class TeacherServiceImpl implements TeacherService {
    @Override
    public String getTeacher(Long id) throws InterruptedException {
        System.err.println("执行getTeacher");
        Thread.sleep(6000);
        System.out.println("等待了6秒，继续执行");
        return "获得" + id + "号老师数据";
    }
}
