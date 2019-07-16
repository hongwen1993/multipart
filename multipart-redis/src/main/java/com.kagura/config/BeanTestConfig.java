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

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public KaguraBean2 kaguraBean2() {
        KaguraBean2 bean = new KaguraBean2();
        bean.setName("Kagura2");
        return bean;
    }


}
