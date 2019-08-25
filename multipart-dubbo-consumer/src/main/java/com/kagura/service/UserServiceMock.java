package com.kagura.service;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/24 14:46
 * @since 1.0.0
 */
public class UserServiceMock implements UserService{

    public String saveUser(Long id) {
        return "本地伪装 - 容错数据";
    }

}
