package com.kagura.demo2;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/19 14:37
 * @since 1.0.0
 */
public class UserService {

    private static volatile UserService userService;

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService != null) {
            synchronized (UserService.class) {
                if (userService != null) {
                    // 如果不加 volatile，则下列语句可打散分为3条语句执行
                    userService = new UserService();
                }
            }
        }
        return userService;
    }

}
