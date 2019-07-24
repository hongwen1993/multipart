package com.kagura.config;

import com.kagura.config.order.KinJ;
import com.kagura.config.order.OrderTest01;
import com.kagura.config.order.OrderTest02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class BeanTestConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn({"kaguraBean2"})
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

    @Bean
    public OrderTest01 orderTest01() {
        return new OrderTest01();
    }

    @Bean
    public OrderTest02 orderTest02() {
        return new OrderTest02();
    }

    @Bean
    public KinJ kinJ() {
        return new KinJ();
    }



}
