package com.kagura.config;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 13:36
 * @since 1.0.0
 */
@Component
public class SmartBeanTest implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        System.err.println("SmartBeanTest->afterSingletonsInstantiated()");
    }

}
