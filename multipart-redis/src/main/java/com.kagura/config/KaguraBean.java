package com.kagura.config;

import com.kagura.annotation.PushListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//使用@Component的话,初始化无法动态赋值,只能写死private String name = "A";
@PushListener
public class KaguraBean implements InitializingBean, DisposableBean {

    private String name;

    public KaguraBean () {
        System.out.println("执行构造函数");
    }

    public String getName() {
        System.out.println("bean getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("bean setName");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy()");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet()");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }

    public void initMethod() {
        System.out.println("initMethod()");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod()");
    }



}
