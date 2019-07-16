package com.kagura.config;

import com.kagura.annotation.PushListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//使用@Component的话,初始化无法动态赋值,只能写死private String name = "A";
@PushListener
public class KaguraBean2 implements InitializingBean, DisposableBean {

    private String name;

    public KaguraBean2() {
        System.out.println("执行构造函数 2");
    }

    public String getName() {
        System.out.println("bean getName 2");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("bean setName 2");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct() 2");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy() 2");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet() 2");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() 2");
    }

    public void initMethod() {
        System.out.println("initMethod() 2");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod() 2");
    }



}
