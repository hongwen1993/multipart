package com.kagura.controller;

import com.kagura.dao.UserInfoMapper;
import com.kagura.dao.UserMapper;
import com.kagura.model.User;
import com.kagura.model.UserInfo;
import com.kagura.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/4
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private UserMapper userMapper;
    private UserInfoService userInfoService;

    public UserController(UserMapper userMapper, UserInfoService userInfoService) {
        this.userMapper = userMapper;
        this.userInfoService = userInfoService;
    }



    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    // REQUIRED  REQUIRES_NEW  NESTED
    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    @GetMapping("/01")
    public Object test01() {
        dataSourceTransactionManager.setNestedTransactionAllowed(true);
        // 更新 user
        User user = userMapper.selectByPrimaryKey(1);
        user.setName("b");
        userMapper.updateByPrimaryKey(user);
        // 更新 user_info
        userInfoService.f();
        //int a = 0/0;
        return "success";
    }



    @GetMapping("/02")
    public Object test02() {
        System.out.println("test02");
        User user = userMapper.selectByPrimaryKey(1);
        System.err.println(user);
        return user;
    }


}
