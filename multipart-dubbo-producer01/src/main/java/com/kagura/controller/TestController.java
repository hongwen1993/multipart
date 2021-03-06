package com.kagura.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kagura.consumer.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/3 20:42
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference(check = false, timeout = 2000)// , timeout = 2000
    private TeacherService teacherService;

    @GetMapping("/01")
    public void test01(@RequestParam Long id) throws InterruptedException {
        //Thread.sleep(3000);
        System.out.println("虽暂停，仍执行。");
        System.err.println(teacherService.getTeacher(id));
    }

    public static void main(String[] args) {
    }

}
