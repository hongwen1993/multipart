package com.kagura.service;

import com.kagura.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/5/20 0:01
 * @since 1.0.0
 */
public class UserInfoServiceTest extends BaseTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void selectByPrimaryKey() {
        System.out.println(userInfoService.selectByPrimaryKey(1000002));
    }
}