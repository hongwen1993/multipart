package com.kagura.utils;

import org.springframework.context.ApplicationContext;

public class ContextUtils {

    private static ApplicationContext applicationContext;


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ContextUtils.applicationContext = applicationContext;
    }
}
