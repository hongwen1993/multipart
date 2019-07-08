package com.kagura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTestConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public KaguraBean kaguraBean() {
        KaguraBean bean = new KaguraBean();
        bean.setName("Kagura");
        return bean;
    }
}
