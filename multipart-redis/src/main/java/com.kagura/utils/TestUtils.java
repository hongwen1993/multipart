package com.kagura.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.kagura.model.Cat;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Karas
 * @date 2019/7/17 16:48
 */
@Component
public class TestUtils implements InitializingBean {
    @Value("${spring.datasource.username}")
    private String userName;

    private String password = userName;

    public TestUtils() {
        //password = userName;
        //System.out.println(userName);
        //userName = "karas";
        System.out.println(password);
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestUtils afterPropertiesSet : " + userName);
    }



}
