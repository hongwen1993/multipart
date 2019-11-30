package com.kagura.controller;

import com.kagura.dao.UserMapper;
import com.kagura.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/4 22:43
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/01")
    public Object test01() {
        User user = userMapper.selectByPrimaryKey(1);
        System.err.println(user);
        return user;
    }


}
