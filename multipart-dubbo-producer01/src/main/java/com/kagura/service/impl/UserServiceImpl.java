package com.kagura.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kagura.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/15 11:21
 * @since 1.0.0
 */
// 注解@Service必须用在实现类上，而不能用在接口或者抽象类上
// 且@Service并不会将该类实例化，还是需要使用注解@Component
@Service(interfaceClass = UserService.class, token = "123456")
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String saveUser(Long id) {
        System.err.println("已保存用户 : " + id);
        System.err.println("牛皮的不行！");
        return "OK";
    }
}
